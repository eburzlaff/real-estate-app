package com.rsproperties.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Eduardo Burzlaff
 */

@WebServlet(name = "RequestTourAction", urlPatterns = { "/requestTourAction" } )
public class RequestTourAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get tour information from form
        // Notify Agent

        RequestDispatcher dispatcher = request.getRequestDispatcher("requestTourMessage" +
                ".jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
