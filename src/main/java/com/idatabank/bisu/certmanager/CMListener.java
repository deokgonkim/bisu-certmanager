package com.idatabank.bisu.certmanager;

import com.idatabank.bisu.InternalException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CMListener implements ServletContextListener {
    private ServletContext context = null;
    private CertCheckThread checkThread = null;

    public void contextInitialized(ServletContextEvent event) {
        context = event.getServletContext();
        try {
            checkThread = new CertCheckThread();
            System.out.println("CertCheckThread starting ...");
            checkThread.start();
            System.out.println("CertCheckThread is running : " + checkThread.getState());
        } catch ( InternalException e ) {
            System.out.println("Failed to start CertCheckThread with exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        context = event.getServletContext();
        if ( checkThread != null ) {
            System.out.println("CertCheckThread is running : " + checkThread.getState());
            if ( checkThread.isAlive() ) {
                System.out.println("Stopping CertCheckThread ...");
                checkThread.interrupt();
            }
            System.out.println("CertCheckThread is running : " + checkThread.getState());
        }
    }
}
