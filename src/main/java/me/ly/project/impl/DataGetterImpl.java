package me.ly.project.impl;

import me.ly.project.controller.DataGetter;
import me.ly.project.model.CourseModel;
import me.ly.project.service.CourseService;
import me.ly.project.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataGetterImpl implements DataGetter {

    @Autowired
    private TemplateService templateService;

    @Override
    public ListTemplateRes listTemplate(ListTemplateReq listTemplateReq) {
        return null;
    }
}
