/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jshop.model.obj;

import com.jutil.jbd2.conexion.DBObject;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author juan-campos
 */
public class Employee extends DBObject {

    public Employee(String[] data) {
        super(data);
    }

    public String getUser() {
        return values[1];
    }

    public String getPassword() {
        return values[2];
    }

    public String getName() {
        return values[3];
    }

    public String getLastName1() {
        return values[4];
    }

    public String getLastName2() {
        return values[5];
    }

    public LocalDate getBirthday() {
        return LocalDate.parse(values[6]);
    }

    public Long getPhoneNumber() {
        return Long.valueOf(values[7]);
    }

    public String getHomeAddres() {
        return values[8];
    }

    public String getPosition() {
        return values[9];
    }

    public String getEmail() {
        return values[10];
    }

    public LocalDateTime getRegister() {
        return LocalDateTime.parse(values[11]);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getName(), getLastName1(), getLastName2());
    }

}
