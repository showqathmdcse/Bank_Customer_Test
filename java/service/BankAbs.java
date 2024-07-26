package com.java.service;

import com.java.dto.BankCustomer;

public interface BankAbs {
    public int add(BankCustomer bank);
    public void delete(BankCustomer bc);
    public void update(BankCustomer bc);
    public void display(BankCustomer bc);
    public void filter(int ch);
}
