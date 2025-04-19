package com.milan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA")
@NamedQuery(query = "select e from Employee e order by e.name",name = "getEmp_name_asc")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Employee_Name")
    private String name;

    private int age;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "Employee_SSN", unique = true,length = 10,nullable = false)
    private String ssn;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @OneToOne
    private AccessCard accessCard;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REMOVE)
    private List<PayStub> payStub = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Email_Group_Subscriptions",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "email_group_id"))
    private List<EmailGroup> emailGroups = new ArrayList<>();

    @Transient
    private String debugString;

    public void addEmailSubscription(EmailGroup emailGroup) {
        this.emailGroups.add(emailGroup);
    }

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }

    public List<PayStub> getPayStub() {
        return payStub;
    }

    public void addPayStub(PayStub payStub) {
        this.payStub.add(payStub);
    }

    public void setPayStub(List<PayStub> payStub) {
        this.payStub = payStub;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public String getDebugString() {
        return debugString;
    }

    public void setDebugString(String debugString) {
        this.debugString = debugString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", ssn='" + ssn + '\'' +
                ", type=" + type +
                ", accessCard=" + accessCard +
                '}';
    }
}
