package com.rsproperties.controller;

import com.rsproperties.entity.Property;
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
import java.io.IOException;
import java.util.List;

/**
 * Created by eburzlaff.
 */

@WebServlet(name = "ViewMyProperties", urlPatterns = { "/viewMyProperties" } )

public class ViewMyProperties extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        GenericDao<Property> dao = DaoFactory.createDao(Property.class);
        List<Property> myProperties = dao.getAll();
        req.setAttribute("myProperties", myProperties);
        logger.debug("Sending back MY property/ies..." + myProperties);

        RequestDispatcher dispatcher = req.getRequestDispatcher("myProperties" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
