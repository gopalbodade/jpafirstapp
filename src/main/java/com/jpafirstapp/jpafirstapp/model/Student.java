package com.jpafirstapp.jpafirstapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by shubhamrathi on 30/06/17.
 */

@Entity
public class Student {

    @Id
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String name;
    String city;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    String imgPath;
}
