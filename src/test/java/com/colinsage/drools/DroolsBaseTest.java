package com.colinsage.drools;

/**
 * Created by colin on 2017-05-15.
 */
import org.junit.Before;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

/**
 * @author Xiong Zhijun
 * @email hust.xzj@gmail.com
 *
 */
public abstract class DroolsBaseTest {

    protected KieServices kieServices;
    protected KieContainer kieContainer;

    @Before
    public void setUp() {
        kieServices = KieServices.Factory.get();
        kieContainer = kieServices.getKieClasspathContainer();
    }

}