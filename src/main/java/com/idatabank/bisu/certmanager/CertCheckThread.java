package com.idatabank.bisu.certmanager;

import com.idatabank.bisu.InternalException;

import java.io.File;

import java.security.cert.X509Certificate;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import java.util.StringTokenizer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

import javax.servlet.ServletException;

public class CertCheckThread extends Thread {
    public CertCheckThread() throws InternalException {
        super();
        CertManagerContext ctx = null;
        
        ctx = CertManagerContext.getContext();
        
        certStorePath = ctx.getCertStore();
        certStoreDirectory = new File(certStorePath);
        checkInterval = ctx.getCheckInterval();
        
        mailHost = ctx.getMailHost();
        mailFromAddress = ctx.getMailFromAddress();
        mailSubject = ctx.getMailSubject();
        mailBody = ctx.getMailBody();
        
        if ( certStoreDirectory == null || !certStoreDirectory.isDirectory() ) {
            throw new InternalException(ResourceBundle.getBundle("error", Locale.getDefault()).getString("error.certstoreempty") + " ( " + certStorePath + " ) ");
        }
        
        dao = new CertStoreDAO();
    }
    
    public void run() {
        try {
            while ( true ) {
                try {
                    checkCerts();
                }  catch ( InternalException e ) {
                    e.printStackTrace();
                }
                Thread.sleep(checkInterval);
            }
        } catch ( InterruptedException e ) {
            System.out.println("CertCheckThread interrupted");
            e.printStackTrace();
        }
    }
    
    public void checkCerts() throws InternalException {
        List certList = null;
        CertEntity entity = null;
        String id = null;
        X509Certificate cert = null;
        
        Date now = null;
        
        certList = dao.getCertificateList();
        for ( int i = 0 ; i < certList.size() ; i ++ ) {
            entity = (CertEntity)certList.get(i);
            id = entity.getId();
            cert = dao.getCertificateById(id);
            
            long oneDay = 1000L * 86400L;
            long today = System.currentTimeMillis();
            // checking wheather cert expires in 30 Days
            if ( new Date( today + ( oneDay * 30L ) ).after( cert.getNotAfter() ) && new Date( today + ( oneDay * 29L ) ).before( cert.getNotAfter() ) ) {
                // cert is expires in 30 Days
                if ( entity.getManagerMails().indexOf(",") == -1 ) {
                    sendNotificationMail(mailFromAddress, entity.getManagerMails(), mailSubject.replaceAll("DAYSLEFT", "30"), mailBody.replaceAll("CUSTOMER", entity.getName()).replaceAll("CERTIFICATE", entity.getSubjectDn()).replaceAll("DAYSLEFT", "30").replaceAll("NOTAFTER", entity.getNotAfter()));
                } else {
                    StringTokenizer st = new StringTokenizer(entity.getManagerMails(), ",");
                    while ( st.hasMoreTokens() ) {
                        sendNotificationMail(mailFromAddress, st.nextToken(), mailSubject.replaceAll("DAYSLEFT", "30"), mailBody.replaceAll("CUSTOMER", entity.getName()).replaceAll("CERTIFICATE", entity.getSubjectDn()).replaceAll("DAYSLEFT", "30").replaceAll("NOTAFTER", entity.getNotAfter()));
                    }
                }
            } else if ( new Date( today + ( oneDay * 7L ) ).after( cert.getNotAfter() ) && new Date( today + ( oneDay * 6L ) ).before( cert.getNotAfter() ) ) {
                // cert is expires in 7 Days
                 if ( entity.getManagerMails().indexOf(",") == -1 ) {
                     sendNotificationMail(mailFromAddress, entity.getManagerMails(), mailSubject.replaceAll("DAYSLEFT", "7"), mailBody.replaceAll("CUSTOMER", entity.getName()).replaceAll("CERTIFICATE", entity.getSubjectDn()).replaceAll("DAYSLEFT", "7").replaceAll("NOTAFTER", entity.getNotAfter()));
                 } else {
                     StringTokenizer st = new StringTokenizer(entity.getManagerMails(), ",");
                     while ( st.hasMoreTokens() ) {
                         sendNotificationMail(mailFromAddress, st.nextToken(), mailSubject.replaceAll("DAYSLEFT", "7"), mailBody.replaceAll("CUSTOMER", entity.getName()).replaceAll("CERTIFICATE", entity.getSubjectDn()).replaceAll("DAYSLEFT", "7").replaceAll("NOTAFTER", entity.getNotAfter()));
                     }
                 }
            } else if ( new Date( today + ( 1000L * 86400L * 1L ) ).after(cert.getNotAfter()) ) {
                // cert is expires in 1 Days
                 if ( entity.getManagerMails().indexOf(",") == -1 ) {
                     sendNotificationMail(mailFromAddress, entity.getManagerMails(), mailSubject.replaceAll("DAYSLEFT", "1"), mailBody.replaceAll("CUSTOMER", entity.getName()).replaceAll("CERTIFICATE", entity.getSubjectDn()).replaceAll("DAYSLEFT", "1").replaceAll("NOTAFTER", entity.getNotAfter()));
                 } else {
                     StringTokenizer st = new StringTokenizer(entity.getManagerMails(), ",");
                     while ( st.hasMoreTokens() ) {
                         sendNotificationMail(mailFromAddress, st.nextToken(), mailSubject.replaceAll("DAYSLEFT", "1"), mailBody.replaceAll("CUSTOMER", entity.getName()).replaceAll("CERTIFICATE", entity.getSubjectDn()).replaceAll("DAYSLEFT", "1").replaceAll("NOTAFTER", entity.getNotAfter()));
                     }
                 }
            }
        }
    }
    
    public void sendNotificationMail(String from, String to, String subject, String body) throws InternalException {
        Properties props = new Properties();
        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;
        Session msgSession = null;
        MimeBodyPart bodyPart = null;
        MimeMessage msg = null;
        MimeMultipart multipart = null;

        try {        
            props.put("mail.smtp.host", mailHost);
    
//            msgSession = Session.getDefaultInstance(props, null); 
            msgSession = Session.getDefaultInstance(props); 
    
            msgSession.setDebug(true);
    
            msg = new MimeMessage(msgSession); 
    
            fromAddress = new InternetAddress(from); 
            toAddress = new InternetAddress(to);
            multipart = new MimeMultipart();
            bodyPart = new MimeBodyPart();
    
            msg.setFrom(fromAddress);
            msg.setRecipient(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject,"EUC-KR"); 
            msg.setText(body, "EUC-KR");
    
            bodyPart.setContent(body, "text/plain; charset=EUC-KR"); 
            multipart.addBodyPart(bodyPart);
            
            msg.setContent(multipart);
            
            Transport.send(msg);
        } catch ( AddressException e ) {
            throw new InternalException(e);
        } catch ( MessagingException e ) {
            throw new InternalException(e);
        }
    }
    
    private CertStoreDAO dao = null;
    private File certStoreDirectory = null;
    private String certStorePath = null;
    private long checkInterval = 0L;
    
    private String mailHost = null;
    private String mailFromAddress = null;
    private String mailSubject = null;
    private String mailBody = null;
}
