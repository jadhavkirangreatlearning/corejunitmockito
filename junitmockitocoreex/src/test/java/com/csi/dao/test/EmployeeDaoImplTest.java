package com.csi.dao.test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @MockBean
    EmployeeRepo employeeRepoImpl;

    @Test
    public void saveDataTest(){

        Employee employee = new Employee(121, "SWARA", "PUNE", 65000, "SWARA@FINTECHCSI.COM", "SWARA@2023");

        employeeDaoImpl.saveData(employee);

        verify(employeeRepoImpl, times(1)).save(employee);
    }

    @Test
    public void getDataByNameTest() {

        String name = "SWARA";
        when(employeeRepoImpl.findByEmpName(name))
                .thenReturn(Stream.of(new Employee(121, "SWARA", "PUNE", 65000, "SWARA@FINTECHCSI.COM", "SWARA@2023")).collect(Collectors.toList()));
        assertEquals(1, employeeDaoImpl.getDataByName(name).size());
    }

    @Test
    public void getAllDataTest(){

        when(employeeRepoImpl.findAll()).thenReturn(Stream.of(new Employee(121, "SWARA", "PUNE", 65000, "SWARA@FINTECHCSI.COM", "SWARA@2023"),
                new Employee(121, "SWARA", "PUNE", 65000, "SWARA@FINTECHCSI.COM", "SWARA@2023")).collect(Collectors.toList()));

        assertEquals(2, employeeDaoImpl.getAllData().size());


    }

    @Test
    public void signInTest(){

        when(employeeRepoImpl.findAll()).thenReturn(Stream.of(  new Employee(121, "SWARA", "PUNE", 65000, "SWARA@FINTECHCSI.COM", "SWARA@2023")).collect(Collectors.toList()));

      assertEquals(true, employeeDaoImpl.signIn("SWARA@FINTECHCSI.COM", "SWARA@2023"));

       // assertTrue(employeeDaoImpl.signIn("SWARA@FINTECHCSI.COM", "SWARA@2023"));
    }

    @Test
    public void updateDataTest(){

        Employee employee = new Employee(121, "SWARA", "PUNE", 65000, "SWARA@FINTECHCSI.COM", "SWARA@2023");

        employeeDaoImpl.updateData(employee);

        verify(employeeRepoImpl, times(1)).save(employee);
    }

    @Test
    public void deleteDataByIdTest(){
        Employee employee = new Employee(121, "SWARA", "PUNE", 65000, "SWARA@FINTECHCSI.COM", "SWARA@2023");

        employeeDaoImpl.deleteDataById(employee.getEmpId());

        verify(employeeRepoImpl, times(1)).deleteById(employee.getEmpId());


    }
}
