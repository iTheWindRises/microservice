package com.zwj.course.service;

import com.zwj.course.dto.CourseDTO;
import com.zwj.course.mapper.CourseMapper;
import com.zwj.thrift.user.UserInfo;
import com.zwj.thrift.user.dto.TeacherDTO;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program microservice
 * @description:
 * @author: wj
 * @create: 2018/11/20 15:36
 */
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ServiceProvider serviceProvider;


    @Override
    public List<CourseDTO> courseList() {
        List<CourseDTO> courseDTOS = courseMapper.listCourse();
        if (courseDTOS != null) {
            for (CourseDTO courseDTO : courseDTOS) {
                Integer teacherId = courseMapper.getCourseTeacher(courseDTO.getId());
                if (teacherId != null) {
                    try {
                        UserInfo userInfo = serviceProvider.getUserService().getTeacherById(teacherId);
                        courseDTO.setTeacher(trans2Teacher(userInfo));
                    } catch (TException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return courseDTOS;
    }

    private TeacherDTO trans2Teacher(UserInfo userInfo) {
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(userInfo,teacherDTO);
        return teacherDTO;
    }
}
