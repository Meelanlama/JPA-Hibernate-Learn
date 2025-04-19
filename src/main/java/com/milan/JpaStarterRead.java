package com.milan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {

        //running the read here
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Employee employee = entityManager.find(Employee.class, 1);
//        System.out.println("********** Employee Name **********");
//        System.out.println(employee.getName());
//        System.out.println("********** Employee Card **********");
//        System.out.println(employee.getAccessCard());

//        AccessCard card = entityManager.find(AccessCard.class, 3);
//        System.out.println(card.getOwner());

//        System.out.println("***** Before fetching employee *****");
//        Employee employee = entityManager.find(Employee.class, 1);
//        System.out.println("***** Before accessing employee *****");
//        System.out.println(employee.getPayStub());

//        PayStub payStub = entityManager.find(PayStub.class, 5);
//        System.out.println(payStub.getEmployee());

        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 7);
        System.out.println("*** GOT EMAIL GROUP, Now accessing employee list");
        System.out.println(emailGroup.getEmployeeList());

        entityManager.close();
        entityManagerFactory.close();
    }
}
