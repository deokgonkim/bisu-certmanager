package com.idatabank.bisu.certmanager.servlet;

import com.idatabank.bisu.InternalException;
import com.idatabank.bisu.certmanager.CertManagerContext;

import com.oreilly.servlet.MultipartRequest;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Enumeration;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.*;
import javax.servlet.http.*;

public class UploadAction extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        CertManagerContext ctx = null;
        
        try {
            ctx = CertManagerContext.getContext();
            
            certStorePath = ctx.getCertStore();
            certStoreDirectory = new File(certStorePath);
            
            if ( certStoreDirectory == null || !certStoreDirectory.isDirectory() ) {
                throw new InternalException(ResourceBundle.getBundle("error", Locale.getDefault()).getString("error.certstoreempty"));
            }
        } catch ( InternalException e ) {
            throw new ServletException(e);
        }
    }

    public void service(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException {
        MultipartRequest mpr = null;
        
        File customerDir = null;
        File certFile = null;
        File keyFile = null;
        File propFile = null;
        Properties props = null;
        SimpleDateFormat df = null;
        
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        
        props = new Properties();
        df = new SimpleDateFormat("yyyyMMdd");
        
        String fileName = null;
        mpr = new MultipartRequest(request, certStorePath, 104857600, "EUC_KR", new DefaultFileRenamePolicy());
//        Enumeration en = mpr.getFileNames();
//        Class c = null;
        fileName = mpr.getFilesystemName("file");
//        while ( en.hasMoreElements() ) {
//            c = en.nextElement().getClass();
//            fileName = c.toString();
            //fileName = (String)en.nextElement().toString();
//        }

        customerDir = new File(certStorePath + "/" + mpr.getParameter("customer"));
        
        customerDir.mkdir();
        
        propFile = new File(customerDir + "/cert.properties");
        fos = new FileOutputStream(propFile);
        bos = new BufferedOutputStream(fos);
        
        props.setProperty("customerpersonnel", mpr.getParameter("customerpersonnel"));
        props.setProperty("customerpersonnelmail", mpr.getParameter("customerpersonnelmail"));
        props.setProperty("manager", mpr.getParameter("manager"));
        props.setProperty("managermail", mpr.getParameter("managermail"));
        props.setProperty("comment", mpr.getParameter("comment"));
        
        props.store(bos, "nocomment");
        
        certFile = new File(customerDir + "/cert.pem");
        keyFile = new File(customerDir + "/key.pem");
        
        if ( certFile != null && certFile.exists() ) {
            new File(customerDir + "/" + df.format(new Date())).mkdir();
            certFile.renameTo(new File(customerDir + "/" + df.format(new Date()) + "/cert.pem"));
        }
        
        if ( keyFile != null && keyFile.exists() ) {
            new File(customerDir + "/" + df.format(new Date())).mkdir();
            keyFile.renameTo(new File(customerDir + "/" + df.format(new Date()) + "/key.pem"));
        }
        
        if ( mpr.getFile("cert") != null ) {
            mpr.getFile("cert").renameTo(new File(customerDir + "/cert.pem"));
        }
        
        if ( mpr.getFile("key") != null ) {
            mpr.getFile("key").renameTo(new File(customerDir + "/key.pem"));    
        }
        
        response.setContentType(CONTENT_TYPE);
        RequestDispatcher dispatcher = null;
        dispatcher = request.getRequestDispatcher("/upload_succeed.jsp");
        dispatcher.forward(request, response);
    }
    
    private String certStorePath = null;
    private File certStoreDirectory = null;
}
