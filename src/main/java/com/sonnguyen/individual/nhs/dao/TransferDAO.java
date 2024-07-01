package com.sonnguyen.individual.nhs.dao;

import com.sonnguyen.individual.nhs.model.Transfer;
import com.sonnguyen.individual.nhs.dao.Idao.ITransferDAO;

import javax.enterprise.inject.Model;
import java.sql.Connection;
import java.sql.SQLException;
@Model
public class TransferDAO extends DAO<Transfer,Integer> implements ITransferDAO {

    @Override
    public Class<Transfer> getEntityClass() {
        return Transfer.class;
    }

    @Override
    public Transfer startTransfer(Connection connection,Transfer transfer) throws SQLException {
            transfer.setId(executeInsert(connection,transfer,getEntityClass()));
            return transfer;
    }

}
