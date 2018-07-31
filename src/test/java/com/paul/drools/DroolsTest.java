package com.paul.drools;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * Created by hzzhouminmin on 2018/7/30.
 */
public class DroolsTest extends DroolsBaseTest {

    @Test
    public void test() {
        KieSession kSession = kieContainer.newKieSession("ksession-rules");
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        kSession.insert(message);
        kSession.fireAllRules();
    }
}
