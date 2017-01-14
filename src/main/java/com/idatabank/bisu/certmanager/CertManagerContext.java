package com.idatabank.bisu.certmanager;

import com.idatabank.bisu.InternalException;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class CertManagerContext {
    public CertManagerContext() throws InternalException {
        InputStream is = null;
        Properties props = null;
        ResourceBundle rb = null;
        try {
            is = this.getClass().getResourceAsStream("/certmanager.properties");
            
            rb = ResourceBundle.getBundle("error", Locale.getDefault());
            
            if ( is != null ) {
                props = new Properties();
                props.load(is);
                certStore = props.getProperty("certmanager.certstore");
                checkInterval = Long.valueOf(String.valueOf(props.getProperty("certmanager.checkinterval"))).longValue();
                
                mailHost = ResourceBundle.getBundle("mailer", Locale.KOREAN).getString("mail.host");
                mailFromAddress = ResourceBundle.getBundle("mailer", Locale.KOREAN).getString("mail.fromaddress");
                mailSubject = ResourceBundle.getBundle("mailer", Locale.KOREAN).getString("mail.subject");
                mailBody = ResourceBundle.getBundle("mailer", Locale.KOREAN).getString("mail.body");
                while ( certStore.indexOf('$') != -1 ) {
                    System.out.println("found : " + certStore);
                    String envName = certStore.substring(certStore.indexOf('{') + 1, certStore.indexOf('}'));
                    String env = System.getProperty(envName);
                    certStore = certStore.substring(0, certStore.indexOf('$')) + env + certStore.substring(certStore.indexOf('}') + 1, certStore.length());
                }
            } else {
                throw new InternalException(rb.getString("error.noconfig"));
            }
        } catch ( IOException e ) {
            throw new InternalException(rb.getString("error.noconfig"));
        }
    }
    
    public String getCertStore() {
        return certStore;
    }
    
    public void setCertStore(String path) {
        certStore = path;
    }
    
    public void setCheckInterval(long checkInterval) {
        this.checkInterval = checkInterval;
    }
    
    public long getCheckInterval() {
        return checkInterval;
    }
    
    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }
    
    public String getMailHost() {
        return mailHost;
    }
    
    public void setMailFromAddress(String mailFromAddress) {
        this.mailFromAddress = mailFromAddress;
    }

    public String getMailFromAddress() {
        return mailFromAddress;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public String getMailBody() {
        return mailBody;
    }
    
    public static synchronized CertManagerContext getContext() throws InternalException {
        if ( ctx == null ) {
            ctx = new CertManagerContext();
        }
        return ctx;
    }
    
    private static CertManagerContext ctx = null;
    
    private String certStore = null;
    private long checkInterval = 0L;
    
    private String mailHost = null;
    private String mailFromAddress = null;
    private String mailSubject = null;
    private String mailBody = null;
}
