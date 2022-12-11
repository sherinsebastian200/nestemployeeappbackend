package com.example.nestemployeeapp_backend.dao;

import com.example.nestemployeeapp_backend.model.Tasks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<Tasks,Integer> {

    @Query(value = "SELECT  e.`company`, e.`designation`, e.`empcode`, e.`empname`, e.`mobile`,t.task,t.status FROM `employ_detail` e JOIN task t ON e.empcode=t.empcode",nativeQuery = true)
    List<Map<String,String>> ViewAllTask();
}
