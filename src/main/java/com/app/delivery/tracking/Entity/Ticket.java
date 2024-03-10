package com.app.delivery.tracking.Entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DELIVERYID")
    private int deliveryId; // Reference to DeliveryDetail
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRIORITY")
    private int priority; // Calculated priority
    @Column(name = "CREATEDTIME")
    private Timestamp createdTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
}

