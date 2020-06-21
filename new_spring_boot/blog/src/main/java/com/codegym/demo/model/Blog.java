package com.codegym.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    private String title;
=======

    @Column
    private String content;

    @Column
>>>>>>> a6e4ba35633b58093c05efca83bf6874c08efe53
    private String tomTatNoiDung;

    @Column
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customers;

    public Blog() {
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
=======
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
>>>>>>> a6e4ba35633b58093c05efca83bf6874c08efe53
    }

    public String getTomTatNoiDung() {
        return tomTatNoiDung;
    }

    public void setTomTatNoiDung(String tomTatNoiDung) {
        this.tomTatNoiDung = tomTatNoiDung;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }


}