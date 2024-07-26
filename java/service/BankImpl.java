package com.java.service;

import com.java.dao.BankAbstract;
import com.java.dto.BankCustomer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BankImpl implements BankAbs {
  BankAbstract bc=new com.java.dao.BankImpl();
    @Override
    public int add(BankCustomer bank) {
        int status=bc.add(bank);
        return status;
    }

    @Override
    public void delete(BankCustomer bank) {
      bc.delete(bank);
    }

    @Override
    public void update(BankCustomer bank) {
      bc.update(bank);
    }

    @Override
    public void display(BankCustomer bank) {
        ArrayList<BankCustomer> d= (ArrayList<BankCustomer>) bc.display(bank);
        Iterator itr=d.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    @Override
    public void filter(int choice) {
      BankCustomer bd=new BankCustomer();
      Scanner sc= new Scanner(System.in);
      if(choice==1){
          System.out.println("enter account number");
          bd.setActNumber(sc.nextInt());
          bc.fetchByActNum(bd);
      }
      if(choice==2){
          System.out.println("enter account holder name");
          bd.setCustomerName(sc.next());
          bc.fetchByName(bd);
      }
      if(choice==3){
          System.out.println("enter account branch code");
          bd.setBranchCode(sc.nextInt());
          bc.branchCode(bd);
      }
      if(choice==4){
          bc.fetchByGroup(bd);

      }
      if(choice>4){
          System.out.println("invalid choice");
      }
    }
}
