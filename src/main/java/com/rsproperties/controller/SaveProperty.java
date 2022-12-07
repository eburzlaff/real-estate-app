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
import java.util.List;

/**
 * Created by Eduardo Burzlaff
 */

@WebServlet(name = "SaveProperty", urlPatterns = { "/saveProperty" } )
public class SaveProperty extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        GenericDao<User> userDao = DaoFactory.createDao(User.class);
        GenericDao<Property> propertyDao = DaoFactory.createDao(Property.class);

        User user = (User) session.getAttribute("user");
        String propertyId = request.getParameter("propertyId");
        String saveAction = request.getParameter("action");
        Property property = propertyDao.getById(Integer.parseInt(propertyId));

        if (saveAction.equals("save")) {
            user.addProperty(property);
            property.setUser(user);
        }

        if (saveAction.equals("unsave")) {
            user.removeProperty(property);
            property.setUser(null);
        }

//        propertyDao.saveOrUpdate(property);

        response.sendRedirect("viewMyProperties");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
