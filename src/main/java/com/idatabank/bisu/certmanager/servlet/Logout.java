package com.idatabank.bisu.certmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        RequestDispatcher dispatcher = null;
        HttpSession session = null;
        session = request.getSession(true);
        session.invalidate();
        dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
