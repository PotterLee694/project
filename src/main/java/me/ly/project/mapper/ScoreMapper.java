package me.ly.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScoreMapper {
    int insert(@Param("userId") Long userId, @Param("reportId") Long reportId, @Param("score") Integer score);

    Double getAvgScore(@Param("reportId") Long reportId);

    int countRecord(@Param("userId") Long userId, @Param("reportId") Long reportId);

    Integer getScore(@Param("userId") Long userId, @Param("reportId") Long reportId);

    int update(@Param("userId") Long userId, @Param("reportId") Long reportId, @Param("score") Integer score);
}
