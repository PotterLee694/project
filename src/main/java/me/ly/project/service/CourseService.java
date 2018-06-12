package me.ly.project.service;

import me.ly.project.mapper.CourseMapper;
import me.ly.project.mapper.LikeMapper;
import me.ly.project.model.CourseModel;
import me.ly.project.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private LikeMapper likeMapper;

    public List<CourseModel> listCourse(Long userID, Page page) {
        return courseMapper.queryCourses(userID, page);
    }

    public List<CourseModel> listLikedCourse(Long userID, Page page) {
        return likeMapper.queryLikedCourse(userID, page);
    }

    public int courseCount(Page page) {
        return courseMapper.queryCourseCount(page);
    }

    public Boolean isLiked(Long userId, Long courseId) {
        int count = likeMapper.findLikedCourse(userId, courseId);
        return (count > 0);

    }

    public List<CourseModel> listCourseOfStudent(Long userID) {
        return null;

    }
}
