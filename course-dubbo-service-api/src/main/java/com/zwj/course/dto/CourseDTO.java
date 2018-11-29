package com.zwj.course.dto;

import com.zwj.thrift.user.dto.TeacherDTO;

/**
 * @program microservice
 * @description:
 * @author: wj
 * @create: 2018/11/20 15:23
 */
public class CourseDTO {
    private Integer id;
    private String title;
    private String description;
    private TeacherDTO teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }
}
