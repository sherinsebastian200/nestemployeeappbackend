package com.example.nestemployeeapp_backend.controller;

import com.example.nestemployeeapp_backend.dao.EmployeeDao;
import com.example.nestemployeeapp_backend.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemploy",consumes = "application/json" ,produces = "application/json")
    public Map<String,String> AddEmploy(@RequestBody Employees e)
    {
        System.out.println(e.getEmpcode());
        System.out.println(e.getEmpname().toString());
        System.out.println(e.getDesignation().toString());
        System.out.println(e.getSalary());
        System.out.println(e.getCompany().toString());
        System.out.println(e.getMobno());
        System.out.println(e.getAddress().toString());
        System.out.println(e.getUsername().toString());
        System.out.println(e.getPassword().toString());
        System.out.println(e.getConfirm().toString());
        HashMap<String,String> map=new HashMap<>();
        dao.save(e);
        map.put("status","success");

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employlogin",consumes = "application/json" ,produces = "application/json")
    public Map<String,String> EmployLogin(@RequestBody Employees e)
    {
        String username=e.getUsername().toString();
        String password=e.getPassword().toString();
        System.out.println(username);
        System.out.println(password);
        List<Employees> result=(List<Employees>) dao.EmployLogin(e.getUsername(),e.getPassword());
        HashMap<String,String> map=new HashMap<>();
        if(result.size()==0)
        {
            map.put("status","failed");
        }
        else {
            int id=result.get(0).getId();
            map.put("userId",String.valueOf(id));
            map.put("status","success");
        }
        return map;
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewemploy",consumes = "application/json",produces = "application/json")
    public List<Employees> EmployView(@RequestBody Employees e)
    {
        String id=String.valueOf(e.getId());
        System.out.println(id);
        return (List<Employees>) dao.EmployView(e.getId());
    }


}



