package com.paul.spring.retry;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;

public class SpringRetry {

    public static <T, A> T retry(int retryTimes, long retryPeriod, A args, InnerProcess<T, A> innerProcess) {

        RetryTemplate retryTemplate = new RetryTemplate();
        Map<Class<? extends Throwable>, Boolean> retryableExceptions = new HashMap<>();
        retryableExceptions.put(Exception.class, Boolean.TRUE);
        retryTemplate.setRetryPolicy(new SimpleRetryPolicy(retryTimes, retryableExceptions));

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(retryPeriod);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        RecoveryCallback<T> recoveryCallback = context -> {
            System.out.println("no way, i'm recoverty");
            return null;
        };

        RetryCallback<T, Exception> retryCallback = context -> {
            return innerProcess.process(args);
        };

        try {
            return retryTemplate.execute(retryCallback, recoveryCallback);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @FunctionalInterface
    public interface InnerProcess<T, A> {

        public T process(A args) throws Exception;

    }
}
