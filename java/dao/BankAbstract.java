package com.java.dao;

import com.java.dto.BankCustomer;

import java.util.List;

public interface BankAbstract {
    public int add(BankCustomer customer);
    public void update(BankCustomer customer);
    public void delete(BankCustomer customer);
    public List<BankCustomer> display(BankCustomer customer);

    public void fetchByActNum(BankCustomer custome);
    public void fetchByName(BankCustomer custome);
    public void branchCode(BankCustomer custome);
    public void fetchByGroup(BankCustomer cust);
}
