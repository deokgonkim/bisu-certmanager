package com.idatabank.bisu.certmanager.servlet;

import com.idatabank.bisu.InternalException;
import com.idatabank.bisu.certmanager.CertStoreDAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.List;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;

public class GetCertificate extends HttpServlet {
    private static final String CONTENT_TYPE = "text/plain; charset=8859-1";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        RequestDispatcher dispatcher = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        File f = null;
        
        CertStoreDAO dao = null;
        try {
            dao = new CertStoreDAO();
            f = dao.getCertificateFileById(request.getParameter("ID"));
            if ( f == null ) {
                throw new InternalException(request.getParameter("ID") + ResourceBundle.getBundle("error", Locale.getDefault()).getString("error.nocertbyid"));
            }
            try {
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                
                os = response.getOutputStream();
                response.setContentType("application/x-x509-ca-cert");
                bos = new BufferedOutputStream(os);
                
                int buf = 0;
                while ( ( buf = bis.read() ) != -1 ) {
                    bos.write(buf);
                }
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
                if ( bos != null ) {
                    try {
                        bos.close();
                    } catch ( IOException e ) {
                        e.printStackTrace();
                    }
                }
            }
        } catch ( InternalException e ) {
            request.setAttribute(PageContext.EXCEPTION, e);
            dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
