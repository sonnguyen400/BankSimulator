package com.sonnguyen.individual.nhs.controller.user;

import com.sonnguyen.individual.nhs.model.SavingsInfo;
import com.sonnguyen.individual.nhs.service.iservice.IAccountService;
import com.sonnguyen.individual.nhs.service.iservice.ISavingsInfoService;
import org.springframework.http.HttpStatus;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/app/saving/account")
public class SavingDetailController extends HttpServlet {
    @Inject
    IAccountService accountService;
    @Inject
    ISavingsInfoService savingsInfoService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<SavingsInfo> savingsInfo= Optional.ofNullable(req.getParameter("id"))
                .map(Integer::parseInt).flatMap(accountService::findById).flatMap(account -> savingsInfoService.findByAccountId(account.getId()).map(savingsInfo1 -> {
                    savingsInfo1.setAccount(account);
                    return savingsInfo1;
                }));
        if(savingsInfo.isPresent()){
            req.setAttribute("savings",savingsInfo.get());
            req.getRequestDispatcher("/page/user/SavingAccountDetail/page.jsp").forward(req,resp);
        }else {
            resp.sendError(HttpStatus.NOT_FOUND.value(),"Saving account not found");
        }

    }



}
