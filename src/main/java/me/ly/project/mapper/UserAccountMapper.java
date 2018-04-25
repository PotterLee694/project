package me.ly.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiYan
 * @date 2018/4/24 1:05
 */
@Mapper
public interface UserAccountMapper {
    int check(@Param("stuNo") Long stuNo, @Param("password") String password);
}
