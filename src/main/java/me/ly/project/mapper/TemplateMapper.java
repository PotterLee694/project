package me.ly.project.mapper;

import me.ly.project.model.TemplateModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TemplateMapper {
    int insert(TemplateModel templateModel);

    List<TemplateModel> queryTemplates(@Param("userID") Long userID);
}
