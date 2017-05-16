package com.colinsage.drools;

/**
 * Created by colin on 2017-05-15.
 */
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
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

        kSession = kieContainer.newKieSession("ksession-rules");
        message.setMessage("How are you.");
        message.setStatus(Message.GOODBYE);
        kSession.insert(message);

        kSession.fireAllRules();
    }
}