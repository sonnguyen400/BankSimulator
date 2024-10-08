package com.sonnguyen.individual.nhs.dao.impl;

import com.sonnguyen.individual.nhs.dao.core.AbstractDAO;
import com.sonnguyen.individual.nhs.dao.idao.IBranchDAO;
import com.sonnguyen.individual.nhs.model.Branch;

import javax.enterprise.inject.Model;

@Model
public class BranchDAOImpl extends AbstractDAO<Branch,Integer> implements IBranchDAO {

    @Override
    protected Class<Branch> getEntityType() {
        return Branch.class;
    }

    @Override
    protected Class<Integer> getIdType() {
        return Integer.class;
    }
}
