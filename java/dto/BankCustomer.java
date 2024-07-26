package com.java.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BankCustomer {
        @Id
        private int actNumber;
        private String customerName;
        private double actBalance;
        private String city;
        private int branchCode;


    public BankCustomer(int actNumber, String customerName, double actBalance, String city, int branchCode) {
        this.actNumber = actNumber;
        this.customerName = customerName;
        this.actBalance = actBalance;
        this.city = city;
        this.branchCode = branchCode;


    }

    public BankCustomer() {

    }

    @Override
    public String toString() {
        return "BankCustomer{" +
                "actNumber=" + actNumber +
                ", customerName='" + customerName + '\'' +
                ", actBalance=" + actBalance +
                ", city='" + city + '\'' +
                ", branchCode=" + branchCode +
                '}';
    }
}
