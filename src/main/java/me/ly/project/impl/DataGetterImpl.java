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
    private CourseService courseService;
    @Autowired
    private TemplateService templateService;
    @Override
    public ListCourseRes listCourse(ListCourseReq listCourseReq) {

        List<CourseModel> list = courseService.listCourse(listCourseReq.getUserID(), listCourseReq.getThePage());
        ListCourseRes listCourseRes = new ListCourseRes().setRecords(list);
        int count = courseService.courseCount(listCourseReq.getUserID());
        listCourseRes.setPage(listCourseReq.getThePage().setTotalCount(count));
        return listCourseRes;
    }

    @Override
    public ListCourseRes listCourseOfStudent(ListCourseReq listCourseReq) {
        return null;
    }

    @Override
    public ListTemplateRes listTemplate(ListTemplateReq listTemplateReq) {
        return null;
    }
}
