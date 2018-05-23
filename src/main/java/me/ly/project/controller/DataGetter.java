package me.ly.project.controller;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.ly.project.model.CourseModel;
import me.ly.project.model.PageReq;
import me.ly.project.model.PageRes;
import me.ly.project.model.TemplateModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface DataGetter {
    @PostMapping("/listCourse")
    ListCourseRes listCourse(@RequestBody ListCourseReq listCourseReq);
    @PostMapping("/listCourseOfStudent")
    ListCourseRes listCourseOfStudent(ListCourseReq listCourseReq);

    @PostMapping("/listTemplate")
    ListTemplateRes listTemplate(ListTemplateReq listTemplateReq);


    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListCourseReq extends PageReq {
        private Long userID;
    }

    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListCourseRes extends PageRes{
        private List<CourseModel> records;
    }

    @Data @Accessors(chain = true)
    class ListTemplateReq extends PageReq{
        private Long userID;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListTemplateRes extends PageRes {
        private List<TemplateModel> records;
    }



}

