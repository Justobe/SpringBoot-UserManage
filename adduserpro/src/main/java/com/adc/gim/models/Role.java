package com.adc.gim.models;

/**
 * Created by YanMing on 2017/5/18.
 */


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="myrole")
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private String rolename;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}