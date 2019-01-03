package com.example.admin.finishcourse.lessonEight;
/**
 * @author Thuan Envity
 * @date 2018/12/27
 */

import java.io.Serializable;
import java.util.List;

public class StudentData implements Serializable {
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
