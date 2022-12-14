package com.rsproperties.controller;

import com.rsproperties.entity.Property;
import com.rsproperties.entity.SavedProperty;
import com.rsproperties.entity.User;
//import com.rsproperties.entity.UserSavedProperty;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Eduardo Burzlaff
 */

@WebServlet(name = "SaveProperty", urlPatterns = { "/saveProperty" } )
public class SaveProperty extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        GenericDao<User> userDao = DaoFactory.createDao(User.class);
        GenericDao<Property> propertyDao = DaoFactory.createDao(Property.class);
        GenericDao<SavedProperty> savedPropertyDao = DaoFactory.createDao(SavedProperty.class);
//        GenericDao<UserSavedProperty> userSavedPropertyDao = DaoFactory.createDao(UserSavedProperty.class);

        User user = (User) session.getAttribute("user");
        String propertyId = request.getParameter("propertyId");
        String saveAction = request.getParameter("action");

        Property property = propertyDao.getById(Integer.parseInt(propertyId));
        String address = property.getAddress();
        String price = property.getPrice();
        String description = property.getDescription();
        String propertyType = property.getPropertyType();
        String availabilityType = property.getAvailabilityType();
        String bedroomNumber = property.getBedroomNumber();
        String bathroomNumber = property.getBathroomNumber();
        String image = property.getBase64Image();

        SavedProperty savedProperty = new SavedProperty();


//        UserSavedProperty userSavedProperty = new UserSavedProperty();
//        userSavedProperty.setSavedProperty(savedProperty);
//        userSavedProperty.setUser(user);

        if (saveAction.equals("save")) {
            savedProperty.setId(property.getId());
            savedProperty.setAddress(address);
            savedProperty.setPrice(price);
            savedProperty.setDescription(description);
            savedProperty.setPropertyType(propertyType);
            savedProperty.setAvailabilityType(availabilityType);
            savedProperty.setBedroomNumber(bedroomNumber);
            savedProperty.setBathroomNumber(bathroomNumber);
            savedProperty.setBase64Image(image);
            user.getSavedProperties().add(savedProperty);
            savedProperty.getUsers().add(user);
        }

        if (saveAction.equals("unsave")) {
            user.getSavedProperties().remove(savedProperty);
            savedProperty.getUsers().remove(user);
            savedProperty.setUsers(null);
            savedProperty.setAddress(null);
            savedProperty.setPrice(null);
            savedProperty.setDescription(null);
            savedProperty.setAvailabilityType(null);
            savedProperty.setBedroomNumber(null);
            savedProperty.setBathroomNumber(null);
            savedProperty.setBase64Image(null);
            savedPropertyDao.delete(savedProperty);

        }

        response.sendRedirect("viewMyProperties");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
