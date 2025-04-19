package com.milan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaPersistenceContextDemo {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("New Employee");
        employee1.setAge(23);
        employee1.setSsn("987654321");
        employee1.setDob(new Date());
        employee1.setType(EmployeeType.INTERN);

        System.out.println("******* Created Employee Instance *******");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();
        transaction.begin();
        System.out.println("******* Starting Transaction *******");

        entityManager.persist(employee1);
        System.out.println("******* After Employee Persisted *******");

        Employee employeeFound = entityManager.find(Employee.class, 1);
        System.out.println(employeeFound);
        System.out.println(employee1);
        System.out.println(employee1==employeeFound); //TRUE

        transaction.commit();
        System.out.println("******* Transaction Completed *******");
        entityManager.close();
        entityManagerFactory.close();
    }
}