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

@WebServlet(name = "EditProfile", urlPatterns = { "/editProfile" } )

public class EditProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        GenericDao<User> dao = DaoFactory.createDao(User.class);

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        User user = (User) session.getAttribute("user");
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        dao.saveOrUpdate(user);


        response.sendRedirect("viewProfile");
    }
}
