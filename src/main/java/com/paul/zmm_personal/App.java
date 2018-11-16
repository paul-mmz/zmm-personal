package com.paul.zmm_personal;

import java.util.concurrent.Semaphore;

public class App {

	private static Semaphore semaphore = new Semaphore(1, true);

	public static void main(String[] args) throws InterruptedException {

	    for (int i = 0; i < 1; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquireUninterruptibly();
                        Thread.sleep(60000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        Thread.sleep(1000);

        for (int i = 0; i < 2; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquireUninterruptibly();
                        Thread.sleep(60000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        try {
            System.out.println("semaphore before");
            semaphore.acquireUninterruptibly();
            System.out.println("semaphore ing");
            semaphore.release();
            System.out.println("unlock ");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
