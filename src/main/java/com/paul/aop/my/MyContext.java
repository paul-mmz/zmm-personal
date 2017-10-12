package com.paul.aop.my;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class MyContext {

    /**
     * 属于切面的注解集合
     */
    private Set<Class<? extends Annotation>> aspectAnnoSet = new HashSet<>();

    /**
     * 保存接口数组，key是每个切面的class
     */
    private Map<Class, Set<Class<?>>> interfaceArrMap = new HashMap<>();

    /**
     * 保存InvocationHandler数组，key是每个切面的class
     */
    private Map<Class, InvocationHandler> invocationHandlerMap= new HashMap<>();

    /**
     * 保存bean名字和bean的map，bean实际是每个对象的代理
     */
    private Map<String, Object> beanContainer = new HashMap<>();

    /**
     * 保存接口方法执行时需要织入的切面方法Method
     */
    private Map<String, Map<String, Method>> functionAspectFunctionMap = new HashMap<>();

    public MyContext() {
        init();
    }

    private void init() {
        initAspectAnnoSet();
        handlerAspect();
//        makeInvocationHandlers();
        handlerBean();
    }

    private void initAspectAnnoSet() {
        aspectAnnoSet.add(MyBefore.class);
        aspectAnnoSet.add(MyAfter.class);
        aspectAnnoSet.add(MyAround.class);
        aspectAnnoSet.add(MyReturn.class);
        aspectAnnoSet.add(MyException.class);
    }

    private void handlerAspect() {
        /** 只处理MyAspect这一个切面,省略了查找切面的过程 */
        Class aspectClazz = MyAspect.class;
        Method[] methods = aspectClazz.getMethods();

        Set<Class<?>> aspectInterfaces = new HashSet<>();
        for (Method method : methods) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            if (declaredAnnotations == null || declaredAnnotations.length <= 0
                    || declaredAnnotations.length > 1) {
                continue;
            }
            if (!checkIsAspectAnnotation(declaredAnnotations[0])) {
                continue;
            }
            Annotation annotation = declaredAnnotations[0];
            /** 该切面注解中切入的接口 */
            Class<?> interfClazz = innerHandlerAnnotation(annotation, method);
            /** 加入到该切面切入的接口集合中 */
            aspectInterfaces.add(interfClazz);
        }

        if (aspectInterfaces.size() > 0) {
            interfaceArrMap.put(aspectClazz, aspectInterfaces);
        }

    }

    private boolean checkIsAspectAnnotation(Annotation annotation) {
        if (annotation == null) {
            return false;
        }
        if (annotation instanceof MyBefore) {
            return true;
        } else if (annotation instanceof MyAfter) {
            return true;
        } else if (annotation instanceof MyAround) {
            return true;
        } else if (annotation instanceof MyReturn) {
            return true;
        } else if (annotation instanceof MyException) {
            return true;
        }
        return false;
    }

    /**
     * 处理切面方法上的注解
     * @param annotation
     */
    private Class<?> innerHandlerAnnotation(Annotation annotation, Method method) {
        if (annotation == null) {
            return null;
        }

        /**
         * 返回的接口Class
         */
        Class<?> interClazz = null;
        String key = null;

        if (annotation instanceof MyBefore) {
            MyBefore before = (MyBefore) annotation;
            Class inter = before.clazz();
            if (inter.isInterface()) {
                interClazz = inter;
            }

            /** 记录这个注解的方法作用的类+方法的String作为key */
//            key = inter.getSimpleName() + before.value();

            key = before.value();
            Map<String, Method> stringMethodMap = functionAspectFunctionMap.get(key);
            if (stringMethodMap == null) {
                stringMethodMap = new HashMap<>();
            }
            stringMethodMap.put("before", method);
            /** key对应的方法，执行执勤啊先执行before关键字对应的方法 */
            functionAspectFunctionMap.put(key, stringMethodMap);

        } else if (annotation instanceof MyAfter) {
            MyAfter after = (MyAfter) annotation;
            Class inter = after.clazz();
            if (inter.isInterface()) {
                interClazz = inter;
            }

//            key = inter.getSimpleName() + before.value();
            key = after.value();

            Map<String, Method> stringMethodMap = functionAspectFunctionMap.get(key);
            if (stringMethodMap == null) {
                stringMethodMap = new HashMap<>();
            }
            stringMethodMap.put("after", method);

            functionAspectFunctionMap.put(key, stringMethodMap);

        } else if (annotation instanceof MyAround) {
            MyAround around = (MyAround) annotation;
            Class inter = around.clazz();
            if (inter.isInterface()) {
                interClazz = inter;
            }

//            key = inter.getSimpleName() + before.value();
            key = around.value();

            Map<String, Method> stringMethodMap = functionAspectFunctionMap.get(key);
            if (stringMethodMap == null) {
                stringMethodMap = new HashMap<>();
            }
            stringMethodMap.put("around", method);

            functionAspectFunctionMap.put(key, stringMethodMap);

        } else if (annotation instanceof MyReturn) {
            MyReturn retuurn = (MyReturn) annotation;
            Class inter = retuurn.clazz();
            if (inter.isInterface()) {
                interClazz = inter;
            }

//            key = inter.getSimpleName() + retuurn.value();
            key = retuurn.value();

            Map<String, Method> stringMethodMap = functionAspectFunctionMap.get(key);
            if (stringMethodMap == null) {
                stringMethodMap = new HashMap<>();
            }
            stringMethodMap.put("return", method);

            functionAspectFunctionMap.put(key, stringMethodMap);

        } else if (annotation instanceof MyException) {
            MyException exception = (MyException) annotation;
            Class inter = exception.clazz();
            if (inter.isInterface()) {
                interClazz = inter;
            }

//            key = inter.getSimpleName() + exception.value();
            key = exception.value();

            Map<String, Method> stringMethodMap = functionAspectFunctionMap.get(key);
            if (stringMethodMap == null) {
                stringMethodMap = new HashMap<>();
            }
            stringMethodMap.put("exception", method);

            functionAspectFunctionMap.put(key, stringMethodMap);
        }
        return interClazz;
    }

    /**
     * 为每个切面声明一个InvocationHandler
     */
    private void makeInvocationHandlers() {
        if (interfaceArrMap == null || interfaceArrMap.size() <= 0) {
            return;
        }
        for (Class<?> aspect : interfaceArrMap.keySet()) {
            Set<Class<?>> classes = interfaceArrMap.get(aspect);
            if (classes == null || classes.size() <= 0) {
                continue;
            }
            Class<?>[] interClazzArr = new Class<?>[classes.size()];
            interClazzArr = classes.toArray(interClazzArr);

//            innerMakeInvocationHandler()
        }
    }

    /**
     * 产生bean并存入容器中
     */
    private void handlerBean() {
        /** 只处理MyEntity，省略bean查找的过程, 这里只处理MyAspect 切入 MyEntity的过程 */

        Class<?> aspectClazz = MyAspect.class;
        Set<Class<?>> classes = interfaceArrMap.get(aspectClazz);
        if (classes == null || classes.size() <= 0) {
            return;
        }
        Class<?>[] interClazzArr = new Class<?>[classes.size()];
        interClazzArr = classes.toArray(interClazzArr);

        /** 分别声明被代理对象，切面对象*/
        MyEntity target = new MyEntity();

        MyAspect aspect = new MyAspect();

        /** 代理对象的实际处理类 */
        MyInvocationHandler handler = new MyInvocationHandler(target, functionAspectFunctionMap, aspect);

        Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), interClazzArr, handler);

        beanContainer.put("myEntity", proxy);
    }

    /**
     * 根据名字获得bean
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        if (StringUtils.isEmpty(beanName)) {
            return null;
        }
        return beanContainer.get(beanName);
    }


}
