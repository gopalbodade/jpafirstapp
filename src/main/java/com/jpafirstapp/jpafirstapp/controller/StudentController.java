package com.jpafirstapp.jpafirstapp.controller;

import com.jpafirstapp.jpafirstapp.model.Student;
import com.jpafirstapp.jpafirstapp.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    @RequestMapping(value="/uploadimage")
    public String uploadImage(@RequestParam Integer id,
                              @RequestParam String name,
                              @RequestParam String city,
                              @RequestParam MultipartFile img)
    {
        String imageName=img.getOriginalFilename();
        String imagePath="/Users/shubhamrathi/Desktop/Image/";
        String path=imagePath+imageName;
        File f=new File("/Users/shubhamrathi/Desktop/Image/"+imageName);
        try {
            img.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student s=new Student();
        s.setImgPath(path);
        s.setName(name);
        s.setId(id);
        s.setCity(city);

        studentRepo.save(s);
     return "success";
    }

}
