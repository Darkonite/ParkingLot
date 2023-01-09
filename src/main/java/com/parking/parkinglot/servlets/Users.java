package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.ejb.InvoiceBean;
import com.parking.parkinglot.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {

    @Inject
    UsersBean userBean;
    @Inject
    InvoiceBean invoiceBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users=userBean.findAllUsers();
        request.setAttribute("users",users);
        if(!invoiceBean.getUserIds().isEmpty())
        {
            Collection<String>usernames = userBean.findUsernamesByUserIds(invoiceBean.getUserIds());
            request.setAttribute("invoice", usernames);
        }

        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String[] userIdsAsString = request.getParameterValues("user_ids");
if(userIdsAsString!=null)
{List<Long> userIds=new ArrayList<>();
    for(String userIdAsString : userIdsAsString)
    {userIds.add(Long.parseLong(userIdAsString));}
    invoiceBean.getUserIds().addAll(userIds);
}
response.sendRedirect(request.getContextPath()+"/Users");
    }
}
