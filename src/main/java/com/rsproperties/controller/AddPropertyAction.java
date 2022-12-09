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
import java.util.Properties;

/**
 * Created by Eduardo Burzlaff
 */

@WebServlet(name = "AddPropertyAction", urlPatterns = { "/addPropertyAction" } )

public class AddPropertyAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        GenericDao<User> userDao = DaoFactory.createDao(User.class);
        GenericDao<Property> propertyDao = DaoFactory.createDao(Property.class);

        String address = request.getParameter("address");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String propertyType = request.getParameter("propertyType");
        String availabilityType = request.getParameter("availabilityType");
        String bedroomNumber = request.getParameter("bedroomNumber");
        String bathroomNumber = request.getParameter("bathroomNumber");
        String propertyImage = request.getParameter("image");


        User user = (User) session.getAttribute("user");
        Property property = new Property();
        property.setAddress(address);
        property.setUser(user);
        property.setPrice(Integer.parseInt(price));
        property.setDescription(description);
        property.setPropertyType(propertyType);
        property.setAvailabilityType(availabilityType);
        property.setBedroomNumber(Integer.parseInt(bedroomNumber));
        property.setBathroomNumber(Integer.parseInt(bathroomNumber));
        user.addProperty(property);

        propertyDao.insert(property);
        userDao.saveOrUpdate(user);

        response.sendRedirect("viewMyListings");
    }
}
