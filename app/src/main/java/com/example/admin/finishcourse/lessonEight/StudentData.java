package com.example.admin.finishcourse.lessonEight;

import java.util.List;

public class StudentData {
    private List<Student> studentList;

    public StudentData() {
    }

    public StudentData(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
