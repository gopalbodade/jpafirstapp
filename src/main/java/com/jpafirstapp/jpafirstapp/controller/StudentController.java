package com.jpafirstapp.jpafirstapp.controller;

import com.jpafirstapp.jpafirstapp.model.Student;
import com.jpafirstapp.jpafirstapp.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shubhamrathi on 30/06/17.
 */

@RestController
public class StudentController {

@Autowired
StudentRepo studentRepo;

@GetMapping(value="/getdata")
public List<Student> getList(){

    List<Student> list=studentRepo.findAll();
    return list;
}

@PostMapping(value = "/postData")
    public ResponseEntity<?> post(@RequestBody
                              Student  student){
    Student save = studentRepo.save(student);
    Map<String,Object> map=new HashMap();

    map.put("status","success");
    map.put("result",save);

   // ResponseEntity<Student> entity=new ResponseEntity("student saved successfully", HttpStatus.OK);
     ResponseEntity<?> entity=ResponseEntity.ok(map);
    return entity;
}

}
