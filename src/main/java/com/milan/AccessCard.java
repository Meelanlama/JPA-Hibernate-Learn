package com.milan;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCESS_CARD")
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date issuedDate;
    private boolean isActive;
    private String firmwareVersion;

    @OneToOne(mappedBy = "accessCard")
    private Employee owner;

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", issuedDate=" + issuedDate +
                ", isActive=" + isActive +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }
}
