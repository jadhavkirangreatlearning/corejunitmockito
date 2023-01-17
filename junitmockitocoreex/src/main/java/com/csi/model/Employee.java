package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private int empId;

    private String empName;

    private String empAddress;

    private double empSalary;

    private String empEmailId;

    private String empPassword;

}
