package com.jpafirstapp.jpafirstapp.repository;

import com.jpafirstapp.jpafirstapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shubhamrathi on 30/06/17.
 */
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
