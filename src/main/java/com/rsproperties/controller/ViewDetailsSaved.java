package com.rsproperties.controller;

import com.rsproperties.entity.Property;
import com.rsproperties.entity.SavedProperty;
import com.rsproperties.persistence.GenericDao;
import com.rsproperties.util.DaoFactory;

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

@WebServlet(name = "ViewDetailsSaved", urlPatterns = { "/viewDetailsSaved" } )
public class ViewDetailsSaved extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenericDao<SavedProperty> dao = DaoFactory.createDao(SavedProperty.class);
        request.setAttribute("property", dao.getById(Integer.parseInt(request.getParameter("id"))));
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewDetails" +
                ".jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
