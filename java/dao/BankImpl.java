package com.java.dao;

import com.java.config.Connection;
import com.java.dto.BankCustomer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankImpl implements BankAbstract {


    @Override
    public int add(BankCustomer customer) {
        EntityManager em= Connection.getEntityManager();
        BankCustomer bc1= new BankCustomer();


        bc1.setActNumber(customer.getActNumber());
        bc1.setCustomerName(customer.getCustomerName());
        bc1.setActBalance(customer.getActBalance());
        bc1.setCity(customer.getCity());
        bc1.setBranchCode(customer.getBranchCode());


        em.getTransaction().begin();

        em.persist(bc1);


        Query query = em.createQuery("Select c from BankCustomer AS c ");
        List<BankCustomer> list =query.getResultList();
        int count=0;
        if(list!=null)
        {
            count++;
        }
        em.getTransaction().commit();
        return count;

    }

    @Override
    public void update(BankCustomer customer) {
        EntityManager em= Connection.getEntityManager();
        em.getTransaction().begin();
        BankCustomer temp= em.find(BankCustomer.class, customer.getActNumber());
        temp.setActBalance(customer.getActBalance());
        temp.setCity(customer.getCity());
        em.getTransaction().commit();
    }

    @Override
    public void delete(BankCustomer customer) {
        EntityManager em= Connection.getEntityManager();
        em.getTransaction().begin();
        BankCustomer temp=  em.find(BankCustomer.class,customer.getActNumber());
        em.remove(temp);
        em.getTransaction().commit();
    }

    @Override
    public List<BankCustomer> display(BankCustomer customer) {
        EntityManager em= Connection.getEntityManager();
        Query query = em.createQuery("Select c from BankCustomer AS c ");
        List<BankCustomer> list =query.getResultList();
        return list;
    }

    @Override
    public void fetchByActNum(BankCustomer cust) {
      EntityManager em= Connection.getEntityManager();
      Query query = em.createQuery("SELECT c from BankCustomer AS c  where c.actNumber="+cust.getActNumber()+"");
      List<BankCustomer> list =query.getResultList();
     Iterator<BankCustomer> iterator = list.iterator();
     while (iterator.hasNext())
     {
         System.out.println(iterator.next());
     }
    }

    @Override
    public void fetchByName(BankCustomer cust) {
        EntityManager em= Connection.getEntityManager();
        Query query = em.createQuery("Select c from BankCustomer c WHERE c.customerName ='"+ cust.getCustomerName()+"'");
        List<BankCustomer> list =query.getResultList();
        for(BankCustomer b:list){
            System.out.println(b);
        }
    }

    @Override
    public void branchCode(BankCustomer cust) {
        EntityManager em= Connection.getEntityManager();
        Query query = em.createQuery("Select c from BankCustomer c WHERE c.branchCode ="+ cust.getBranchCode()+"");
        List<BankCustomer> list =query.getResultList();
        for(BankCustomer b:list){
            System.out.println(b);
        }
    }

    @Override
    public void fetchByGroup(BankCustomer cust) {
        EntityManager em= Connection.getEntityManager();
        Query query= em.createQuery("SELECT e.city,e.customerName,MAX(actBalance)from BankCustomer e group by city,customerName,actBalance ");
        List<Object[]> empList = query.getResultList();
        for(Object[] ob: empList)
        {
            System.out.println(ob[0]+":"+ob[1]+":"+ob[2]);
        }
    }
}
