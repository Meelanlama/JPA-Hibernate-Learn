package com.milan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //fetching data of employee and that python email group
        Employee employee = entityManager.find(Employee.class, 2);
        EmailGroup emailGroup = entityManager.find(EmailGroup.class,8);

        //updating
        employee.addEmailSubscription(emailGroup);
        emailGroup.addEmployee(employee);

        EntityTransaction transaction =  entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);
        entityManager.persist(emailGroup);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
