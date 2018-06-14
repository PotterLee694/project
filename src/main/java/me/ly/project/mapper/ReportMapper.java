package me.ly.project.mapper;

import me.ly.project.model.CourseModel;
import me.ly.project.model.Page;
import me.ly.project.model.ReportModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
    int insert(ReportModel reportModel);

    List<CourseModel> listNeedReport(@Param("userId") Long userId, @Param("page") Page page);

    List<ReportModel> listReports(@Param("page") Page page);

    ReportModel queryReport(@Param("id") Long id);

    ReportModel findReport(@Param("userId") Long userId, @Param("courseId") Long courseId);

    int queryReportCount(@Param("page") Page page);

    int queryNeedReportCount(@Param("userId") Long userId, @Param("page") Page page);

}
