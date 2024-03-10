package com.app.delivery.tracking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "DELIVERYDETAIL")
public class DeliveryDetail {
    @Id
    @Column(name = "DELIVERYID")
    private int deliveryId;
    @Column(name = "CUSTOMERTYPE")
    private String customerType;
    @Column(name = "DELIVERYSTATUS")
    private String deliveryStatus;
    @Column(name = "EXPECTEDDELIVERYTIME")
    private Timestamp expectedDeliveryTime;
    @Column(name = "CURRENTDISTANCEFROMDESTINATIONINMETERS")
    private int currentDistanceFromDestinationInMeters;
    @Column(name = "TIMETOREACHDESTINATION")
    private Timestamp timeToReachDestination;

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Timestamp getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(Timestamp expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public int getCurrentDistanceFromDestinationInMeters() {
        return currentDistanceFromDestinationInMeters;
    }

    public void setCurrentDistanceFromDestinationInMeters(int currentDistanceFromDestinationInMeters) {
        this.currentDistanceFromDestinationInMeters = currentDistanceFromDestinationInMeters;
    }

    public Timestamp getTimeToReachDestination() {
        return timeToReachDestination;
    }

    public void setTimeToReachDestination(Timestamp timeToReachDestination) {
        this.timeToReachDestination = timeToReachDestination;
    }
}
