package com.example.thimoudle3.model.entity;

import java.time.LocalDate;
import java.util.Date;

public class Room {
    private int roomId;
    private String tenantName;
    private String phoneNumber;
    private Date startDate;
    private int paymentMethodId;
    private String note;


    public Room () {

    }

    public Room(String tenantName, String phoneNumber, Date startDate, int paymentMethodId, String note) {
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.paymentMethodId = paymentMethodId;
        this.note = note;
    }

    public Room(int roomId, String tenantName, String phoneNumber, Date startDate, int paymentMethodId, String note) {
        this.roomId = roomId;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.paymentMethodId = paymentMethodId;
        this.note = note;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return String.valueOf(startDate);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStartDate(LocalDate startDate) {
    }
}