package me.ly.project.mapper;

import me.ly.project.model.CourseModel;
import me.ly.project.model.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    int insert(CourseModel courseModel);

    int delete(@Param("id") Long id);

    List<CourseModel> queryCourses(@Param("userID") Long userID, @Param("page") Page page);


    CourseModel getCourse(@Param("id") Long id);

    int queryCourseCount(@Param("page") Page page);

    int update(CourseModel courseModel);

    List<CourseModel> queryOverCourses();
}
