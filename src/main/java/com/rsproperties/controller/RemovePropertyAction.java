package com.rsproperties.controller;

import com.rsproperties.entity.Property;
import com.rsproperties.entity.User;
import com.rsproperties.persistence.GenericDao;
import com.rsproperties.util.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Eduardo Burzlaff
 */

@WebServlet(name = "RemovePropertyAction", urlPatterns = { "/removePropertyAction" } )
public class RemovePropertyAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        GenericDao<User> userDao = DaoFactory.createDao(User.class);
        GenericDao<Property> propertyDao = DaoFactory.createDao(Property.class);

        User user = (User) session.getAttribute("user");
        String propertyId = request.getParameter("id");
        Property property = propertyDao.getById(Integer.parseInt(propertyId));

        user.removeProperty(property);
        session.setAttribute("user", user);
        propertyDao.delete(property);

        RequestDispatcher dispatcher = request.getRequestDispatcher("viewMyListings");
        dispatcher.forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
