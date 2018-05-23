package me.ly.project.mapper;

import me.ly.project.model.CourseModel;
import me.ly.project.model.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    int insert(CourseModel courseModel);
    List<CourseModel> queryCourses(@Param("userID") Long userID, @Param("page") Page page);

    int queryCourseCount(@Param("userID") Long userID);
}
