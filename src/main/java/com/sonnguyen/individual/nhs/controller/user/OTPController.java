package com.sonnguyen.individual.nhs.controller.user;

import com.sonnguyen.individual.nhs.utils.OTPUtils;
import com.sonnguyen.individual.nhs.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.sonnguyen.individual.nhs.utils.RequestUtils.ERROR_MESSAGE;

@WebServlet(name = "otp-validate",urlPatterns = "/app/otp")
public class OTPController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/page/user/EnterOTP/page.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("otp") != null){
            if(OTPUtils.isValid(req)){
                req.setAttribute("OTP","VALID");
                req.getRequestDispatcher((String) SessionUtils.getSession(req,"endpoint")).forward(req,resp);
            }else {
                System.out.println("Invalid OTP");
                req.setAttribute(ERROR_MESSAGE,"Invalid OTP");
                doGet(req,resp);
            }
        }else{
            doGet(req,resp);
        }
    }

}
