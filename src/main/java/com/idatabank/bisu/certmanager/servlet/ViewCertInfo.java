package com.idatabank.bisu.certmanager.servlet;

import com.idatabank.bisu.InternalException;
import com.idatabank.bisu.certmanager.CertEntity;
import com.idatabank.bisu.certmanager.CertStoreDAO;

import com.idatabank.bisu.utility.File2Text;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;

public class ViewCertInfo extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        RequestDispatcher dispatcher = null;
        
        CertEntity certEntity = null;
        File certFile = null;
        File keyFile = null;
        
        CertStoreDAO dao = null;
        try {
            dao = new CertStoreDAO();
            
            certEntity = dao.getCertificateEntityById(request.getParameter("ID"));
            if ( certEntity == null ) {
                throw new InternalException(request.getParameter("ID") + ResourceBundle.getBundle("error", Locale.getDefault()).getString("error.nocertbyid"));
            }
            certFile = dao.getCertificateFileById(request.getParameter("ID"));
            keyFile = dao.getPrivateKeyById(request.getParameter("ID"));
            request.setAttribute("certentity", certEntity);
            request.setAttribute("certpem", File2Text.toString(certFile));
            request.setAttribute("keypem", keyFile != null ? File2Text.toString(keyFile) : "no keyfile");
            dispatcher = request.getRequestDispatcher("/view_cert_info.jsp");
            dispatcher.forward(request, response);
        } catch ( InternalException e ) {
            request.setAttribute(PageContext.EXCEPTION, e);
            dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
