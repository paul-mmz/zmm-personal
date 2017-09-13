package com.paul.proxy;

public class TestClass implements TestInterface, ShowProxy{
	  
    public void method1() {  
        System.out.println("TestClass.method1");  
    }  
  
    public void method2() {  
        System.out.println("TestClass.method2");  
    }  
  
    public void method3() {  
        System.out.println("TestClass.method3");  
    }

    @Override
    public String myHandlerFunction() {
        System.out.println("hah, i'm in the other Class.");
        return this.getClass().getName();
    }
}
