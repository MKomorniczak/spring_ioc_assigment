package org.example.service;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.sequencer.StudentSequencer;
import org.example.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManagementConsoleImpl implements StudentManagement {
    private UserInputService scannerService;
    private StudentDao studentDao;

    public void setScannerService(UserInputService scannerService) {
        this.scannerService = scannerService;
    }


    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("What is your name?");
        String name = scannerService.getString();
        System.out.println("What is your id?");
        int id = scannerService.getInt();
        Student student = new Student(id, name);
        System.out.println(student);

        return student;
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("not valid");
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        if (id == 0) throw new IllegalArgumentException("not valid");

        Student foundedStudent = studentDao.find(id);
        System.out.println(foundedStudent.toString());
        return foundedStudent;
    }

    @Override
    public Student remove(int id) {
        if (id != 0) throw new IllegalArgumentException("not valid");

        Student findAnyStudent = find(id);


        studentDao.delete(findAnyStudent.getId());
        return findAnyStudent;
    }

    @Override
    public List<Student> findAll() {
        List<Student> foundedStudents = new ArrayList<>();
        if (foundedStudents == null) throw new IllegalArgumentException("not valid");
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student == null) throw new IllegalArgumentException("not valid");
        Student updatedStudent = find(student.getId());
        updatedStudent.setName(student.getName());
        return updatedStudent;

    }
}
