package com.idatabank.bisu.certmanager;

import com.idatabank.bisu.InternalException;

import com.idatabank.bisu.utility.Base64Util;

import com.idatabank.bisu.utility.HexUtil;

import java.io.BufferedInputStream;
import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;

import java.text.SimpleDateFormat;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class CertStoreDAO {
    public CertStoreDAO() throws InternalException {
        CertManagerContext ctx = null;
        
        ctx = CertManagerContext.getContext();
        
        certStorePath = ctx.getCertStore();
        certStoreDirectory = new File(certStorePath);
        
        if ( certStoreDirectory == null || !certStoreDirectory.isDirectory() ) {
            throw new InternalException(ResourceBundle.getBundle("error", Locale.getDefault()).getString("error.certstoreempty"));
        }
    }
    
    private X509Certificate getCertificateFromDirectory(File certDir) throws InternalException {
        X509Certificate cert = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        
        File[] files = null;
        
        files = certDir.listFiles();
                
        for ( int i = 0 ; i < files.length ; i ++ ) {
            
            if ( files[i].getName().contains("cert.pem") ) {
                try {
                    fis = new FileInputStream(files[i]);
                    bis = new BufferedInputStream(fis);
                    
                    CertificateFactory cf = CertificateFactory.getInstance("X.509");
                    
                    while (bis.available() > 0) {
                        cert = (X509Certificate)cf.generateCertificate(bis);
                    }
                } catch ( FileNotFoundException e ) {
                    throw new InternalException(e);
                } catch ( IOException e ) {
                    throw new InternalException(e);
                } catch ( CertificateException e ) {
                    throw new InternalException(e);
                } finally {
                    if ( bis != null ) {
                        try {
                            bis.close();
                        } catch ( IOException e ) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
        return cert;
    }
    
    private File getCertificateFileFromDirectory(File certDir) throws InternalException {
        File certFile = null;
        
        File[] files = null;
        
        files = certDir.listFiles();
                
        for ( int i = 0 ; i < files.length ; i ++ ) {
            if ( files[i].getName().contains("cert.pem") ) {
                certFile = files[i];
            }
        }
        
        return certFile;
    }
    
    private File getPrivateKeyFileFromDirectory(File certDir) throws InternalException {
        File keyFile = null;
        
        File[] files = null;
        
        files = certDir.listFiles();
                
        for ( int i = 0 ; i < files.length ; i ++ ) {
            if ( files[i].getName().contains("key") ) {
                keyFile = files[i];
            }
        }
        
        return keyFile;
    }
    
    private CertEntity getCertificateEntityFromDirectory(File certDir) throws InternalException {
        CertEntity entity = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        
        File[] files = null;
        
        files = certDir.listFiles();
        
        X509Certificate cert = null;
        String issuerDn = null;
        String subjectDn = null;
        String notBefore = null;
        String notAfter = null;
        String serial = null;
        String signAlg = null;
        
        String customerPersonnel = null;
        String customerPersonnelMails = null;
        String manager = null;
        String managerMails = null;
        String comment = null;
        
        Properties props = null;
        
        SimpleDateFormat df = null;
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        entity = new CertEntity();
        
        for ( int i = 0 ; i < files.length ; i ++ ) {
            entity.setName(certDir.getName());
            
            if ( files[i].getName().contains("cert.pem") ) {
                try {
                    fis = new FileInputStream(files[i]);
                    bis = new BufferedInputStream(fis);
                    
                    CertificateFactory cf = CertificateFactory.getInstance("X.509");
                    
                    try {
                        while (bis.available() > 0) {
                            cert = (X509Certificate)cf.generateCertificate(bis);
                            issuerDn = cert.getIssuerDN().getName();
                            subjectDn = cert.getSubjectDN().getName();
                            serial = String.valueOf(cert.getSerialNumber());
                            signAlg = cert.getSigAlgName();
                            notBefore = df.format(cert.getNotBefore());
                            notAfter = df.format(cert.getNotAfter());
                        }
                    } catch ( CertificateParsingException e ) {
                        throw new InternalException(files[i].getParent());
                    }
                } catch ( FileNotFoundException e ) {
                    throw new InternalException(e);
                } catch ( IOException e ) {
                    throw new InternalException(e);
                } catch ( CertificateException e ) {
                    throw new InternalException(e);
                } finally {
                    if ( bis != null ) {
                        try {
                            bis.close();
                        } catch ( IOException e ) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            
            if ( files[i].getName().contains("properties") ) {
                try {
                    fis = new FileInputStream(files[i]);
                    bis = new BufferedInputStream(fis);
                    
                    props = new Properties();
                    props.load(bis);
                    
//                    customerPersonnel = new String(props.getProperty("customerpersonnel").getBytes("iso8859-1"), "EUC-KR");
//                    
//                    manager = new String(props.getProperty("manager").getBytes("iso8859-1"), "EUC-KR");
//                    comment = new String(props.getProperty("comment").getBytes("iso8859-1"), "EUC-KR");;
                    customerPersonnel = props.getProperty("customerpersonnel");
                    customerPersonnelMails = props.getProperty("customerpersonnelmails");
                    
                    manager = props.getProperty("manager");
                    managerMails = props.getProperty("managermail");
                    comment = props.getProperty("comment");

                } catch ( FileNotFoundException e ) {
                    throw new InternalException(e);
                } catch ( IOException e ) {
                    throw new InternalException(e);
                } finally {
                    if ( bis != null ) {
                        try {
                            bis.close();
                        } catch ( IOException e ) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
        //entity.setId(Base64Util.encode(entity.getName().getBytes()));
        entity.setId(HexUtil.toHexString(entity.getName().getBytes()));
        entity.setIssuerDn(issuerDn.replaceAll("EMAILADDRESS", "E"));
        entity.setSubjectDn(subjectDn.replaceAll("EMAILADDRESS", "E"));
        entity.setSerial(serial);
        entity.setSignAlg(signAlg);
        entity.setNotBefore(notBefore);
        entity.setNotAfter(notAfter);
        
        entity.setCustomerPersonnel(customerPersonnel);
        entity.setCustomerPersonnelMails(customerPersonnelMails);
        entity.setManager(manager);
        entity.setManagerMails(managerMails);
        entity.setComment(comment);
        
        return entity;
    }
    
    public List getCertificateList() throws InternalException {
        List lst = null;
        CertEntity certEntity = null;
        File[] files = null;
        
        files = certStoreDirectory.listFiles();
        lst = new LinkedList();
        
        for ( int i = 0 ; i < files.length ; i ++ ) {
            certEntity = getCertificateEntityFromDirectory(files[i]);
            lst.add(certEntity);
        }
        
        return lst;
    }
    
    public CertEntity getCertificateEntityById(String id) throws InternalException {
        CertEntity certificate = null;
        File[] files = null;
        
        files = certStoreDirectory.listFiles();
        
        for ( int i = 0 ; i < files.length ; i ++ ) {
            if ( id.equals( HexUtil.toHexString( files[i].getName().getBytes() ) ) ) {
                certificate = getCertificateEntityFromDirectory(files[i]);
            }
        }
        
        return certificate;
    }
    
    public X509Certificate getCertificateById(String id) throws InternalException {
        X509Certificate certificate = null;
        File[] files = null;
        
        files = certStoreDirectory.listFiles();
        
        for ( int i = 0 ; i < files.length ; i ++ ) {
            if ( id.equals( HexUtil.toHexString( files[i].getName().getBytes() ) ) ) {
                certificate = getCertificateFromDirectory(files[i]);
            }
        }
        
        return certificate;
    }
    
    public File getCertificateFileById(String id) throws InternalException {
        File certificate = null;
        File[] files = null;
        
        files = certStoreDirectory.listFiles();
        
        for ( int i = 0 ; i < files.length ; i ++ ) {
            if ( id.equals( HexUtil.toHexString( files[i].getName().getBytes() ) ) ) {
                certificate = getCertificateFileFromDirectory(files[i]);
            }
        }
        
        return certificate;
    }
    
    public File getPrivateKeyById(String id) throws InternalException {
        File privateKey = null;
        File[] files = null;
        
        files = certStoreDirectory.listFiles();
        
        for ( int i = 0 ; i < files.length ; i ++ ) {
            if ( id.equals( HexUtil.toHexString( files[i].getName().getBytes() ) ) ) {
                privateKey = getPrivateKeyFileFromDirectory(files[i]);
            }
        }
        
        return privateKey;
    }
    
    private String certStorePath = null;
    private File certStoreDirectory = null;
}
