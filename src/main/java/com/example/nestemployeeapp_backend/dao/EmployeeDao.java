package com.example.nestemployeeapp_backend.dao;

import com.example.nestemployeeapp_backend.model.Employees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employees,Integer> {

    @Query(value = "SELECT `id`, `address`, `company`, `confirm`, `designation`, `empcode`, `empname`, `mobno`, `password`, `salary`, `username` FROM `employee` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<Employees> EmployLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `company`, `confirm`, `designation`, `empcode`, `empname`, `mobno`, `password`, `salary`, `username` FROM `employee` WHERE `id`=:id",nativeQuery = true)
    List<Employees> EmployView(@Param("id") Integer id);




}
