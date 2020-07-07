package Models;

import java.util.Date;

public class Booking {
    private int id_customer;
    private int id_detail;
    private int id_services;
    private int id_villa;
    private int id_house;
    private int id_room;
    private java.sql.Date day;
    private int rentday;

    public int getRentday() {
        return rentday;
    }




    public Booking(int id_customer, int id_detail, int id_services, int id_villa, int id_house, int id_room, java.sql.Date day,int rentday) {
        this.id_customer = id_customer;
        this.id_detail = id_detail;
        this.id_services = id_services;
        this.id_villa = id_villa;
        this.id_house = id_house;
        this.id_room = id_room;
        this.day = day;
        this.rentday = rentday;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public int getId_services() {
        return id_services;
    }

    public void setId_services(int id_services) {
        this.id_services = id_services;
    }

    public int getId_villa() {
        return id_villa;
    }

    public void setId_villa(int id_villa) {
        this.id_villa = id_villa;
    }

    public int getId_house() {
        return id_house;
    }

    public void setId_house(int id_house) {
        this.id_house = id_house;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public void setDay(java.sql.Date day) {
        this.day = day;
    }

    public Booking() {
    }
    public void setRentday(int rentday) {
        this.rentday = rentday;
    }

    public java.sql.Date getDay() {
        return day;
    }
}
