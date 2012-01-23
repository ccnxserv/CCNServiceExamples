package edu.columbia.irt.ccn.services.next;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {

    private static final Logger log = Logger.getLogger(Activator.class.getName());
    private static final String SERVICE = "NextService";

    @Override
    public void start(BundleContext context) throws Exception {
        log.info(Activator.SERVICE + " started..");
    }

    @Override
    public void stop(BundleContext context) {
        log.info(Activator.SERVICE + " stopped..");
    }
}
