package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee saveData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public List<Employee> getAllData(){
        return employeeRepoImpl.findAll();
    }

    public boolean signIn(String empEmailId, String empPassword){

        boolean flag=false;

        for(Employee employee: employeeRepoImpl.findAll()){
            if(employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)){
                flag= true;
            }
        }
        return flag;
    }

    public List<Employee> getDataByName(String empName){
        return employeeRepoImpl.findByEmpName(empName);
    }

    public Employee updateData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public void deleteDataById(int empId){
        employeeRepoImpl.deleteById(empId);
    }
}
