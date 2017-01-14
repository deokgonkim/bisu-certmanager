package com.idatabank.bisu.certmanager.servlet;

import com.idatabank.bisu.InternalException;
import com.idatabank.bisu.certmanager.CertEntity;

import com.idatabank.bisu.certmanager.CertStoreDAO;

import com.idatabank.bisu.certmanager.utility.ListSorter;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;

public class ListCertificate extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        RequestDispatcher dispatcher = null;
        List certList = null;
        CertStoreDAO dao = null;
        try {
            dao = new CertStoreDAO();
            certList = ListSorter.sortByName(dao.getCertificateList());
            
//            certList = ListSorter.sortByExpire(dao.getCertificateList());
            request.setAttribute("certlist", certList);
            dispatcher = request.getRequestDispatcher("/list_certificate.jsp");
            dispatcher.forward(request, response);
        } catch ( InternalException e ) {
            request.setAttribute(PageContext.EXCEPTION, e);
            dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
