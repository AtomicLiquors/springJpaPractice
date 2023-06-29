package com.example.jpacruddemo.dao;

import com.example.jpacruddemo.entity.Student;

public interface StudentDAO {
    void save (Student theStudent);

    Student findById(Integer id);
}
