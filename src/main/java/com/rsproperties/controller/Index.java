package com.rsproperties.controller;

import com.rsproperties.entity.Property;
import com.rsproperties.entity.SavedProperty;
import com.rsproperties.persistence.GenericDao;
import com.rsproperties.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

@WebServlet(name = "Index", urlPatterns = { "/home" } )
public class Index extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        GenericDao<Property> propertyDao = DaoFactory.createDao(Property.class);
        GenericDao<SavedProperty> savedPropertyDao = DaoFactory.createDao(SavedProperty.class);
        List<Property> properties = propertyDao.getAll();
        List<SavedProperty> savedProperties = savedPropertyDao.getAll();
        req.setAttribute("properties", properties);
        req.setAttribute("savedProperties", savedProperties);
        logger.debug("Sending back ALL property/ies..." + properties);
        logger.debug("Sending back ALL saved property/ies..." + savedProperties);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
