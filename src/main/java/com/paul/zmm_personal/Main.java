package com.paul.zmm_personal;/**
 * Created by zhouminmin on 11/07/2017.
 */

import com.paul.spring.retry.SpringRetry;

/**
* @author  hzzhouminmin@corp.netease.com
* @since 11/07/2017
**/
public class Main {

    public static void main(String[] args) {
        String innerArgs = "wo jiu shi innerArgs";
        SpringRetry.retry(5, 5000, innerArgs, iargs -> {
            System.out.println("chong fu le yo");
            System.out.println("dang qian shijain: " + System.currentTimeMillis());
            throw new RuntimeException("chognfu");
        });
    }
}
