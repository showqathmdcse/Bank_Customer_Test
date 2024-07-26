package com.java.io;

import com.java.dto.BankCustomer;
import com.java.service.BankAbs;
import com.java.service.BankImpl;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
       // add();
        // update();
        //delete();
        //display();

    filterb();
    }
    public static void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of your account");
        int no = sc.nextInt();
        System.out.println("Enter the name of your account");
        String name = sc.next();
        System.out.println("Enter the balance of your account");
        double balance = sc.nextDouble();
        System.out.println("Enter the city of your account");
        String city = sc.next();
        System.out.println("Enter the branchcode of your account");
        int branchcode = sc.nextInt();
        BankCustomer b = new BankCustomer();
        b.setActNumber(no);
        b.setCustomerName(name);
        b.setActBalance(balance);
        b.setCity(city);
        b.setBranchCode(branchcode);

        BankAbs be = new BankImpl();
        int status = be.add(b);
        if (status != 0) {
            System.out.println("Account added");
        } else {
            System.out.println("Account not added");
        }
    }

    public static void update(){
        Scanner sc = new Scanner(System.in);
        BankCustomer b = new BankCustomer();
        BankAbs be = new BankImpl();
        System.out.println("enter account bno");
         int no = sc.nextInt();
        System.out.println("enter bal of your account");
        double balance = sc.nextDouble();
        System.out.println("enter city of your account");
        String name = sc.next();
        b.setActNumber(no);
        b.setActBalance(balance);
        b.setCity(name);

        be.update(b);
    }
    public static void display(){
        BankAbs be = new BankImpl();
        be.display(new BankCustomer());
    }

    public static void delete(){
        Scanner sc = new Scanner(System.in);
        BankAbs be = new BankImpl();
        BankCustomer bd = new BankCustomer();
        System.out.println("enter account no");
        int no = sc.nextInt();
        bd.setActNumber(no);
        be.delete(bd);
    }

    public static void filterb(){
        Scanner sc = new Scanner(System.in);
        System.out.println("MEnU:\n 1.selectbynum\n 2.selectname\n   3.selectbybranchcode\n 4.selectbyactnum,name,city");
        System.out.println("enter choice: ");
        int choice = sc.nextInt();
        BankAbs be = new BankImpl();
        be.filter(choice);
    }

}
