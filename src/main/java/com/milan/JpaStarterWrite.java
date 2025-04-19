package com.milan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaStarterWrite {
    public static void main(String[] args) {

        //FOR READING OPERATION:
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Employee employee = entityManager.find(Employee.class, 1);
//        Employee employee1 = entityManager.find(Employee.class, 2);
//        Employee employee3 = entityManager.find(Employee.class, 3);
//        System.out.println("-----------------------------");
//        System.out.println(employee);
//        System.out.println(employee1);
//        System.out.println(employee3); //null

        //UPDATING the entity:
//        employee1.setAge(38);
//        employee1.setType(EmployeeType.FULL_TIME);

        //Deleting the entity:
        // entityManager.remove(employee1);

        Employee employee = new Employee();
        employee.setName("Milan");
        employee.setAge(22);
        employee.setSsn("123456789");
        employee.setDob(new Date());
        employee.setType(EmployeeType.FULL_TIME);

        Employee employee1 = new Employee();
        employee1.setName("Java Brains");
        employee1.setAge(30);
        employee1.setSsn("987654321");
        employee1.setDob(new Date());
        employee1.setType(EmployeeType.INTERN);

        // ----------------------------------------------------------------------------------------------
        // Creating a new instance for Access Card
        AccessCard card1 = new AccessCard();
        card1.setIssuedDate(new Date());
        card1.setActive(true);
        card1.setFirmwareVersion("1.0");
        card1.setOwner(employee);
        employee.setAccessCard(card1);

        AccessCard card2 = new AccessCard();
        card2.setIssuedDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("2.0");
        card2.setOwner(employee1);
        employee1.setAccessCard(card2);

        // ----------------------------------------------------------------------------------------------
        PayStub payStub1 = new PayStub();
        payStub1.setPayPeriodStart(new Date());
        payStub1.setPayPeriodEnd(new Date());
        payStub1.setSalary(100000);
        payStub1.setEmployee(employee);
        employee.addPayStub(payStub1);

        PayStub payStub2 = new PayStub();
        payStub2.setPayPeriodStart(new Date());
        payStub2.setPayPeriodEnd(new Date());
        payStub2.setSalary(200000);
        payStub2.setEmployee(employee);
        employee.addPayStub(payStub2);

        EmailGroup emailGroup1 = new EmailGroup();
        emailGroup1.setGroupName("Java Discussion Group");
        emailGroup1.addEmployee(employee);
        emailGroup1.addEmployee(employee1);
        employee.addEmailSubscription(emailGroup1);
        employee1.addEmailSubscription(emailGroup1);

        EmailGroup emailGroup2 = new EmailGroup();
        emailGroup2.setGroupName("Python Tech Group");
        emailGroup2.addEmployee(employee);
        employee.addEmailSubscription(emailGroup2);

        // ----------------------------------------------------------------------------------------------

//        //"myApp" name in entitymanager factory is from xml file which it's unit name
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee); // creates employee table and insert it to database.
        entityManager.persist(employee1);
       // entityManager.remove(employee1); //remove should be below transaction begin
        entityManager.persist(card1);
        entityManager.persist(card2);

        entityManager.persist(payStub1);
        entityManager.persist(payStub2);

        entityManager.persist(emailGroup1);
        entityManager.persist(emailGroup2);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}