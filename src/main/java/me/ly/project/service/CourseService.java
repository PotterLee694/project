package me.ly.project.service;

import me.ly.project.mapper.CourseMapper;
import me.ly.project.model.CourseModel;
import me.ly.project.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public List<CourseModel> listCourse(Long userID, Page page) {
        return courseMapper.queryCourses(userID, page);
    }

    public int courseCount(Long userID) {
        return courseMapper.queryCourseCount(userID);
    }

    public List<CourseModel> listCourseOfStudent(Long userID) {
        return null;

    }
}
