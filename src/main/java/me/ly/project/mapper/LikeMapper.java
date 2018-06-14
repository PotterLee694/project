package me.ly.project.mapper;

import me.ly.project.model.CourseModel;
import me.ly.project.model.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LikeMapper {
    int insert(@Param("userId") Long userId, @Param("courseId") Long courseId);

    int delete(@Param("userId") Long userId, @Param("courseId") Long courseId);

    List<CourseModel> queryLikedCourse(@Param("userId") Long userId, @Param("page") Page page);

    int findLikedCourse(@Param("userId") Long userId, @Param("courseId") Long courseId);

    int queryCourseCount(@Param("userId") Long userId, @Param("page") Page page);

    List<Long> queryLiker(@Param("courseId") Long courseId);

}
