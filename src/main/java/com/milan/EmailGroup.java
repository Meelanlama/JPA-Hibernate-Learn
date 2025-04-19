package com.milan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EmailGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String groupName;

    @ManyToMany(mappedBy = "emailGroups")
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "EmailGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
