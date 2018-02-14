package com.paul.dubbo;

import com.alibaba.dubbo.config.*;
import com.paul.dubbo.impl.DefaultDemoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        System.setProperty("java.net.preferIPv4Stack", "true");
        ApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        DemoService demoService = (DemoService)context.getBean("demoService");
        if (demoService != null) {
            System.out.println(demoService.sayHello());
        }
    }

    public static class ProviderMain {
        public static void main(String[] args) {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("provider");

            RegistryConfig registry = new RegistryConfig();
            registry.setAddress("N/A");

            ProtocolConfig protocol = new ProtocolConfig();
            protocol.setName("dubbo");
            protocol.setPort(20880);
            protocol.setThreads(200);

            DemoService demoService = new DefaultDemoServiceImpl();

            ServiceConfig<DemoService> serviceConfig = new ServiceConfig<>();
            serviceConfig.setApplication(applicationConfig);
            serviceConfig.setRegistry(registry);
            serviceConfig.setProtocol(protocol);
            serviceConfig.setInterface(DemoService.class);
            serviceConfig.setRef(demoService);

            serviceConfig.export();

            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static class ConsumerMain {
        public static void main(String[] args) {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("consumer");

            ReferenceConfig<DemoService> referenceConfig = new ReferenceConfig<>();
            referenceConfig.setApplication(applicationConfig);
            referenceConfig.setInterface(DemoService.class);
            referenceConfig.setUrl("dubbo://127.0.0.1:20880/com.paul.dubbo.DemoService");
            DemoService demoService = referenceConfig.get();
            System.out.println(demoService.sayHello());
        }

    }
}
