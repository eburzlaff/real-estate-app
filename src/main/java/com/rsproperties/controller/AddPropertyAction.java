package com.rsproperties.controller;

import com.rsproperties.entity.Property;
import com.rsproperties.entity.User;
import com.rsproperties.persistence.GenericDao;
import com.rsproperties.util.DaoFactory;
import org.hibernate.engine.jdbc.BlobProxy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/**
 * Created by Eduardo Burzlaff
 */

@WebServlet(name = "AddPropertyAction", urlPatterns = { "/addPropertyAction" } )

public class AddPropertyAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

        //save image into database
        File file = new File("images/no-image-icon-23494.jpg");
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = (User) session.getAttribute("user");
        Property property = new Property();
        property.setAddress(address);
        property.setUser(user);
        property.setPrice(price);
        property.setDescription(description);
        property.setPropertyType(propertyType);
        property.setAvailabilityType(availabilityType);
        property.setBedroomNumber(bedroomNumber);
        property.setBathroomNumber(bathroomNumber);
        property.setImage(bFile);
        user.addProperty(property);
        propertyDao.insert(property);

        response.sendRedirect("viewMyListings");
    }
}
