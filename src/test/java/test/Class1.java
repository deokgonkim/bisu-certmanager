package test;

import com.idatabank.bisu.certmanager.CertManagerContext;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

public class Class1 {
    public Class1() {
    }
    
    public void test1() throws Exception {
        FileInputStream fis = new FileInputStream("/tmp/cert.pem");
        BufferedInputStream bis = new BufferedInputStream(fis);

        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        while (bis.available() > 0) {
            X509Certificate cert = (X509Certificate)cf.generateCertificate(bis);
            System.out.println(cert.getNotBefore());
            System.out.println(new Date().after(cert.getNotBefore()));
            System.out.println(new Date().before(cert.getNotAfter()));
        //           System.out.println(cert.toString());
        }
    }
    
    public static void main(String[] arg) throws Exception {
        Class1 a = new Class1();
        a.test3();
    }
    
    public void test2() throws Exception {
        CertManagerContext ctx = null;
        ctx = CertManagerContext.getContext();
        File f = null;
        f = new File(ctx.getCertStore());
        System.out.println(f.isDirectory());
        System.out.println(ctx.getCertStore());
    }
    
    public void test3() throws Exception {
        Properties props = null;
        props = System.getProperties();
        Enumeration en = props.keys();
        while ( en.hasMoreElements() ) {
            String name = null;
            name = en.nextElement().toString();
            System.out.println(name + " -- " + System.getProperty(name));
        }
    }
    
}
