package me.ly.project.service;

import me.ly.project.mapper.TemplateMapper;
import me.ly.project.model.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {
    @Autowired
    private TemplateMapper templateMapper;

    public List<TemplateModel> listTemplate(Long userID) {
        return templateMapper.queryTemplates(userID);
    }


}
