package com.colinsage.drools;

/**
 * Created by colin on 2017-05-15.
 */
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message.Level;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.io.KieResources;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class KieFileSystemTest {

    @Test
    public void test() {
        KieServices kieServices = KieServices.Factory.get();
        KieResources resources = kieServices.getResources();
        KieModuleModel kieModuleModel = kieServices.newKieModuleModel();

        KieBaseModel baseModel = kieModuleModel.newKieBaseModel(
                "FileSystemKBase").addPackage("rules");
        baseModel.newKieSessionModel("FileSystemKSession");
        KieFileSystem fileSystem = kieServices.newKieFileSystem();

        String xml = kieModuleModel.toXML();
        System.out.println(xml);
        fileSystem.writeKModuleXML(xml);

        fileSystem.write("src/main/resources/rule.drl", resources
                .newClassPathResource("kiefilesystem/FileSystemTest.drl"));

        KieBuilder kb = kieServices.newKieBuilder(fileSystem);
        kb.buildAll();
        if (kb.getResults().hasMessages(Level.ERROR)) {
            throw new RuntimeException("Build Errors:\n"
                    + kb.getResults().toString());
        }
        KieContainer kContainer = kieServices.newKieContainer(kieServices
                .getRepository().getDefaultReleaseId());

        assertNotNull(kContainer.getKieBase("FileSystemKBase"));
        KieSession kSession = kContainer.newKieSession("FileSystemKSession");

        kSession.fireAllRules();
    }
}