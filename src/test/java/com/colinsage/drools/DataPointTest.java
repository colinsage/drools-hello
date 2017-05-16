package com.colinsage.drools;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * Created by colin on 2017-05-16.
 */
public class DataPointTest extends DroolsBaseTest {

    @Test
    public void test() {
        KieSession kSession = kieContainer.newKieSession("ksession-monitor");

        ConditionedDataPoint dp = new ConditionedDataPoint();
        dp.setMetric("es.cpu.user");
        dp.setTimestamp(124121212L);
        dp.setValue(0.8);
        dp.setWARN(0.7);
        dp.setCRITICAL(0.9);

        kSession.insert(dp);
        kSession.fireAllRules();
    }
}
