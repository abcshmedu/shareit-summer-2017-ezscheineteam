package edu.hm.shareit.util;

import javax.inject.Inject;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Application class to enable guice within jersey.
 * @author <a mailto:axel.boettcher@hm.edu>Axel B&ouml;ttcher</a>
 */
public class ShareItApplication extends ResourceConfig {

    /**
     * init app config.
     * @param serviceLocator serviceLocator
     */
    @Inject
    public ShareItApplication(ServiceLocator serviceLocator) {
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        Module module = new ShareItApplicationModule();
        Injector injector = Guice.createInjector(module);
        guiceBridge.bridgeGuiceInjector(injector);
    }

}