package com.sonnguyen.individual.nhs.controller.user;

import com.sonnguyen.individual.nhs.constant.LoanStatus;
import com.sonnguyen.individual.nhs.model.Customer;
import com.sonnguyen.individual.nhs.model.Login;
import com.sonnguyen.individual.nhs.model.Membership;
import com.sonnguyen.individual.nhs.security.UserDetailImp;
import com.sonnguyen.individual.nhs.security.core.SecurityContextHolder;
import com.sonnguyen.individual.nhs.service.iservice.ICustomerService;
import com.sonnguyen.individual.nhs.service.iservice.ILoanService;
import com.sonnguyen.individual.nhs.service.iservice.IMembershipService;
import com.sonnguyen.individual.nhs.utils.RequestUtils;
import com.sonnguyen.individual.nhs.utils.SessionUtils;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "loan/manage",urlPatterns = "/app/loan")
public class LoanManageController extends HttpServlet {
    @Inject
    ILoanService loanService;
    @Inject
    ICustomerService customerService;
    @Inject
    IMembershipService membershipService;
    @Inject
    SecurityContextHolder securityContextHolder;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDetailImp userDetailImp= (UserDetailImp) securityContextHolder.getPrincipal();
        req.setAttribute("loans",loanService.findAllByCustomerId(userDetailImp.getCustomerId()));
        Customer customer=customerService.findById(userDetailImp.getCustomerId()).get();
        req.setAttribute("membership",membershipService.findById(customer.getMembershipID()).orElse(new Membership()));
        req.getRequestDispatcher("/page/user/LoanManage/page.jsp").forward(req, resp);
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> map=RequestUtils.getParameterMap(req);
        Integer id=Integer.parseInt(map.get("id"));
        try{
            if(LoanStatus.valueOf(map.get("status"))==LoanStatus.APPROVED){
                loanService.approveLoan(id);
            }else{
                loanService.updateStatusById(id, LoanStatus.valueOf(map.get("status")));
            }
        } catch (SQLException | NotFoundException e) {
            resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
