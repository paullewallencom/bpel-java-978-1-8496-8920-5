package org.packt.java.book;

import java.util.Date;

public class Member {

    private int id=0;
    private String name="";
    private String surname="";
    private String address="";
    private Date membershipExpiry= null;

    public Member(int id, String name, String surname, String address,
                  Date membershipExpiry) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.membershipExpiry = membershipExpiry;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMembershipExpiry(Date membershipExpiry) {
        this.membershipExpiry = membershipExpiry;
    }

    public Date getMembershipExpiry() {
        return membershipExpiry;
    }
}
