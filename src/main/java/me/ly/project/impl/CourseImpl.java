package me.ly.project.impl;

import lombok.extern.slf4j.Slf4j;
import me.ly.project.controller.Course;
import me.ly.project.mapper.CourseMapper;
import me.ly.project.mapper.LikeMapper;
import me.ly.project.mapper.NotifyMapper;
import me.ly.project.mapper.UserMapper;
import me.ly.project.model.BaseRes;
import me.ly.project.model.CourseModel;
import me.ly.project.model.NoticeModel;
import me.ly.project.model.UserModel;
import me.ly.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseImpl implements Course {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private NotifyMapper notifyMapper;
    @Autowired
    private CourseService courseService;



    @Override
    public QueryCourseRes getCourse(QueryCourseReq queryCourseReq) {
        QueryCourseRes res = new QueryCourseRes();
        CourseModel course = courseMapper.getCourse(queryCourseReq.getId());
        if (course != null) {
            res.setCourse(course);
        } else {
            res.setSuccess(false);
        }

        return res;
    }

    @Override
    public UpdateCourseRes updateCourse(UpdateCourseReq req) {
        UpdateCourseRes res = new UpdateCourseRes();
        CourseModel reqModel = new CourseModel().setId(req.getId())
                                                .setOwner(req.getOwner())
                                                .setTitle(req.getTitle())
                                                .setDescription(req.getDescription())
                                                .setTeachers(req.getTeachers())
                                                .setCourseTime(req.getCourseTime())
                                                .setCourseOver(req.getCourseOver())
                                                .setInfoPdf(req.getInfoPdf())
                                                .setPrePdf(req.getPrePdf())
                                                .setPreVideo(req.getPreVideo());

        if (reqModel.getId() == null || reqModel.getId().equals(0L)) {
            int count = courseMapper.insert(reqModel);
            if (count <= 0) {
                res.setSuccess(false);
            } else {
                res.setCourse(reqModel);
            }
        } else {
            int count = courseMapper.update(reqModel);
            if (count <= 0) {
                res.setSuccess(false);
            } else {
                res.setCourse(courseMapper.getCourse(reqModel.getId()));
            }

        }
        return res;
    }

    @Override
    public BaseRes delCourse(DelCourseReq delCourseReq) {
        BaseRes baseRes = new UpdateCourseRes();
        int count = courseMapper.delete(delCourseReq.getId());
        if (count <= 0) {
            baseRes.setSuccess(false);
        }
        return baseRes;
    }

    @Override
    public QueryLikedCourseRes listLikedCourse(QueryLikedCourseReq queryLikedCourseReq) {
        QueryLikedCourseRes res = new QueryLikedCourseRes();
        List<CourseModel> courseModels = likeMapper.queryLikedCourse(queryLikedCourseReq.getUserId(), queryLikedCourseReq.getThePage());
        int count = likeMapper.queryCourseCount(queryLikedCourseReq.getUserId(), queryLikedCourseReq.getThePage());
        res.setPage(queryLikedCourseReq.getThePage().setTotalCount(count));
        res.setRecords(courseModels);

        return res;
    }

    @Override
    public ListCourseRes listCourse(ListCourseReq listCourseReq) {
        List<CourseModel> list = courseService.listCourse(listCourseReq.getUserID(), listCourseReq.getThePage());
        list.forEach(courseModel -> {
            courseModel.setLiked(courseService.isLiked(listCourseReq.getUserID(), courseModel.getId()));
        });
        ListCourseRes listCourseRes = new ListCourseRes().setRecords(list);
        int count = courseService.courseCount(listCourseReq.getThePage());
        listCourseRes.setPage(listCourseReq.getThePage().setTotalCount(count));
        return listCourseRes;
    }

    @Override
    public BaseRes likeCourse(LikeCourseReq likeCourseReq) {
        likeMapper.insert(likeCourseReq.getUserId(), likeCourseReq.getCourseId());
        CourseModel course = courseMapper.getCourse(likeCourseReq.getCourseId());
        UserModel userModel = userMapper.queryById(likeCourseReq.getUserId());
        StringBuffer content = new StringBuffer();
        content.append(userModel.getUserName())
               .append("关注了您的课程：")
               .append(course.getTitle());
        notifyMapper.insert(new NoticeModel().setUserId(course.getOwner())
                                             .setType("like")
                                             .setContent(content.toString()));

        return new BaseRes();
    }

    @Override
    public BaseRes deLikeCourse(DeLikeCourseReq deLikeCourseReq) {
        int count = likeMapper.delete(deLikeCourseReq.getUserId(), deLikeCourseReq.getCourseId());
        if (count <= 0) {
            return new BaseRes().setSuccess(false);
        }
        CourseModel course = courseMapper.getCourse(deLikeCourseReq.getCourseId());
        UserModel userModel = userMapper.queryById(deLikeCourseReq.getUserId());
        StringBuffer content = new StringBuffer();
        content.append(userModel.getUserName())
               .append("退出了您的课程：")
               .append(course.getTitle());
        notifyMapper.insert(new NoticeModel().setUserId(course.getOwner())
                                             .setType("like")
                                             .setContent(content.toString()));

        return new BaseRes();
    }

    @Override
    public BaseRes mapTemplate(MapTemplateReq mapTemplateReq) {
        courseMapper.update(new CourseModel().setId(mapTemplateReq.getCourseId())
                                             .setTemplateId(mapTemplateReq.getTemplateId()));
        return new BaseRes();
    }
}
