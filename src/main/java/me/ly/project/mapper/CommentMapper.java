package me.ly.project.mapper;

import me.ly.project.model.CommentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    int insert(@Param("reportId") Long reportId, @Param("userId") Long userId, @Param("comment") String comment);

    List<CommentModel> listComment(@Param("reportId") Long reportId);

    int delZan(@Param("commentId") Long commentId, @Param("userId") Long userId);

    int addZan(@Param("commentId") Long commentId, @Param("userId") Long userId);

    long countZan(@Param("commentId") Long commentId);


}
