package com.example.admin.finishcourse.lessonSix;
/**
 * @author Thuan Envity
 * @date 2018/12/27
 * */
import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;
    private String imageUrl;
    private String status;

    public Student() {
    }

    public Student(String id, String name, String imageUrl, String status) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
