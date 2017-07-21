package com.paul.zmm_personal;/**
 * Created by zhouminmin on 11/07/2017.
 */

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
* @author  hzzhouminmin@corp.netease.com
* @since 11/07/2017
**/
public class Main {

    public static Executor getThreadPool() {
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(100);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 30L, TimeUnit.SECONDS, queue, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                throw new RuntimeException("can't handle taks");
            }
        });
        return executor;
    }

    private static Set<Singleton> set = new HashSet<>();

    private static CountDownLatch countDownLatch;

    private static class Task implements Runnable {

        private CountDownLatch countDownLatch;
        private Integer num;

        public Task(CountDownLatch cd, Integer num) {
            this.countDownLatch = cd;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                set.add(Singleton.getInstance());
            }
            countDownLatch.countDown();
            System.out.println("the " + num + "thread to return");
            return;
        }
    }

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        countDownLatch = new CountDownLatch(10);
        Executor executor = getThreadPool();
        for (int i = 0; i < 10; i++) {
            executor.execute(new Task(countDownLatch, i));
        }
        countDownLatch.await(1000,TimeUnit.MILLISECONDS);
        System.out.println("the last main thread to return");
        System.out.println(set);
        return;
////        Class<? extends Class> aClass = Outer.class.getClass();
//        Class<?> aClass = Class.forName("com.paul.zmm_personal.Outer");
    }
}
