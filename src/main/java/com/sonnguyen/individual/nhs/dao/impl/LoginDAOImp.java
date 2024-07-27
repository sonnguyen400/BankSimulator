package com.sonnguyen.individual.nhs.dao.impl;

import com.sonnguyen.individual.nhs.dao_v2.AbstractDAO;
import com.sonnguyen.individual.nhs.model.Login;

import javax.enterprise.inject.Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Model
public class LoginDAOImp extends AbstractDAO<Login,Integer> {

    @Override
    protected Class<Login> getEntityType() {
        return Login.class;
    }

    @Override
    protected Class<Integer> getIdType() {
        return Integer.class;
    }
    public boolean validatePIN(int loginId,String pin){
        Connection connection=getConnection();
        String query="select case when PIN=? then true else false end as result from login where id=?";
        Integer result=select(connection,query,Integer.class,pin,loginId);
        try {
            connection.close();
        } catch (SQLException|NullPointerException e) {
            System.out.println("Connection can't be closed");
        }
        return result==1;
    }

    public Login validateLogin(String username,String password){
        Connection connection=getConnection();
        String query="select * from login where username=? and password=?";
        List<Login> logins=executeSelect(connection,query,username,password);
        try{
            connection.close();
        } catch (SQLException|NullPointerException e) {
            System.out.println("Connection can't be closed");
        }
        if(logins!=null&&logins.size()==1) return logins.get(0);
        return null;
    }
}
