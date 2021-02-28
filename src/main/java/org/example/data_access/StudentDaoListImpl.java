package org.example.data_access;

import org.example.models.Student;
import org.example.sequencer.StudentSequencer;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoListImpl implements StudentDao{
    List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if (student.getId() == 0){
            student.setId(StudentSequencer.nextStudentId());
            students.add(student);
        }
        return student;
    }

    @Override
    public Student find(int id) {
        if(id==0){
            throw new IllegalArgumentException("not valid");
        }
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Student> findAll() {

        return students;
    }

    @Override
    public void delete(int id) {
       students.removeIf(student -> student.getId()==id);


    }
}
