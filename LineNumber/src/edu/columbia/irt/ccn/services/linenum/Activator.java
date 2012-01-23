/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.columbia.irt.ccn.services.linenum;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author amanus
 */
public class Activator implements BundleActivator {

    private static final Logger log = Logger.getLogger(Activator.class.getName());
    private static final String SERVICE = "LineNumber";

    @Override
    public void start(BundleContext context) throws Exception {
        log.info(Activator.SERVICE + " started..");
    }

    @Override
    public void stop(BundleContext context) {
        log.info(Activator.SERVICE + " stopped..");
    }
}
