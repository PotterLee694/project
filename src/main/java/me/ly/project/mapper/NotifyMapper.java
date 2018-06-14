package me.ly.project.mapper;

import me.ly.project.model.NoticeModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NotifyMapper {
    List<NoticeModel> listNewNotice(@Param("userId") Long userId, @Param("type") String type);

    List<NoticeModel> listNotice(@Param("userId") Long userId, @Param("type") String type);

    int insert(NoticeModel noticeModel);

    int checkNotice(@Param("userId") Long userId, @Param("type") String type);

}
