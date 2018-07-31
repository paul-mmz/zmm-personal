package com.paul.drools;

import org.junit.Before;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

/**
 * Created by hzzhouminmin on 2018/7/30.
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
