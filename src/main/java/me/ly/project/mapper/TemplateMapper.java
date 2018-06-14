package me.ly.project.mapper;

import me.ly.project.model.Page;
import me.ly.project.model.TemplateModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface TemplateMapper {
    int insert(TemplateModel templateModel);

    List<TemplateModel> queryTemplates(@Param("userId") Long userId, @Param("page") Page page);

    int queryTemplateCount(@Param("userId") Long userId, @Param("page") Page page);

    TemplateModel getTemplate(@Param("id") Long id);

    String getMappedCourseName(@Param("id") Long id);

    int update(TemplateModel templateModel);

    int delete(@Param("id") Long id);
}
