package com.sonnguyen.individual.nhs.controller.user;

import com.sonnguyen.individual.nhs.constant.AccountStatus;
import com.sonnguyen.individual.nhs.constant.AccountType;
import com.sonnguyen.individual.nhs.model.Account;
import com.sonnguyen.individual.nhs.model.Customer;
import com.sonnguyen.individual.nhs.model.Membership;
import com.sonnguyen.individual.nhs.security.UserDetailImp;
import com.sonnguyen.individual.nhs.security.core.SecurityContextHolder;
import com.sonnguyen.individual.nhs.service.iservice.IAccountService;
import com.sonnguyen.individual.nhs.service.iservice.ICustomerService;
import com.sonnguyen.individual.nhs.service.iservice.ILoginService;
import com.sonnguyen.individual.nhs.service.iservice.IMembershipService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "savings/manage",urlPatterns = "/app/saving")
public class SavingsManageController extends HttpServlet {
    @Inject
    IAccountService accountService;
    @Inject
    ILoginService loginService;
    @Inject
    IMembershipService membershipService;
    @Inject
    ICustomerService customerService;
    @Inject
    SecurityContextHolder securityContextHolder;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDetailImp login= (UserDetailImp) securityContextHolder.getPrincipal();
        List<Account> accountList=accountService.findByStatusAndTypeAndCustomerId(AccountStatus.OPEN, AccountType.SAVINGS,login.getCustomerId());
        req.setAttribute("accounts",accountList);
        Customer customer=customerService.findById(login.getCustomerId()).orElse(null);
        req.setAttribute("membership",membershipService.findById(customer.getMembershipID()).orElse(new Membership()));
        req.getRequestDispatcher("/page/user/SavingAccountManage/page.jsp").forward(req, resp);
    }
}
