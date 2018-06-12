package me.ly.project.controller;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.ly.project.model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface Course {

    @PostMapping("/listCourse")
    ListCourseRes listCourse(@RequestBody ListCourseReq listCourseReq);

    @PostMapping("/getCourse")
    QueryCourseRes getCourse(QueryCourseReq queryCourseReq);

    @PostMapping("/updateCourse")
    UpdateCourseRes updateCourse(UpdateCourseReq updateCourseReq);

    @PostMapping("/delCourse")
    BaseRes delCourse(DelCourseReq delCourseReq);

    @PostMapping("/listLikedCourse")
    QueryLikedCourseRes listLikedCourse(QueryLikedCourseReq queryLikedCourseReq);

    @PostMapping("likeCourse")
    BaseRes likeCourse(LikeCourseReq likeCourseReq);

    @PostMapping("deLikeCourse")
    BaseRes deLikeCourse(DeLikeCourseReq deLikeCourseReq);




    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListCourseReq extends PageReq {
        private Long userID;
    }

    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListCourseRes extends PageRes{
        private List<CourseModel> records;
    }

    @Data @Accessors(chain = true)
    class QueryCourseReq {
        private Long id;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class QueryCourseRes extends BaseRes {
        private CourseModel course;
    }
    @Data @Accessors(chain = true)
    class UpdateCourseReq {
        private Long id;
        private Long owner;
        private String title;
        private String description;
        private String teachers;
        private String courseTime;
        private Boolean courseOver;
        private String infoPdf;
        private String prePdf;
        private String preVideo;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class UpdateCourseRes extends BaseRes {
        private CourseModel course;
    }
    @Data @Accessors(chain = true)
    class DelCourseReq {
        private Long id;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class QueryLikedCourseRes extends PageRes {
        private List<CourseModel> records;
    }
    @Data @Accessors(chain = true)
    class QueryLikedCourseReq extends PageReq {
        private Long userId;
    }
    @Data @Accessors(chain = true)
    class LikeCourseReq {
        private Long userId;
        private Long courseId;
    }
    @Data @Accessors(chain = true)
    class DeLikeCourseReq {
        private Long userId;
        private Long courseId;
    }
}
