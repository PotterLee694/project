package me.ly.project.impl;

import me.ly.project.controller.Comment;
import me.ly.project.mapper.*;
import me.ly.project.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentImpl implements Comment {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private NotifyMapper notifyMapper;
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public BaseRes addComment(AddCommentReq addCommentReq) {
        commentMapper.insert(addCommentReq.getReportId(), addCommentReq.getUserId(), addCommentReq.getComment());
        ReportModel reportModel = reportMapper.queryReport(addCommentReq.getReportId());
        UserModel userModel = userMapper.queryById(addCommentReq.getUserId());
        CourseModel course = courseMapper.getCourse(reportModel.getCourseId());
        if (reportModel.getUserId() == addCommentReq.getUserId()) {
            return new BaseRes();
        }
        StringBuffer content = new StringBuffer();
        content.append(userModel.getUserName())
               .append("在你的实验报告：").append(course.getTitle()).append(" 中,说道：\"").append(addCommentReq.getComment()).append("\"");
        notifyMapper.insert(new NoticeModel().setType("comment")
                                             .setUserId(reportModel.getUserId()).setContent(content.toString()));

        return new BaseRes();
    }

    @Override
    public ListCommentRes listComment(ListCommentReq listCommentReq) {
        ListCommentRes res = new ListCommentRes();
        List<CommentModel> list = commentMapper.listComment(listCommentReq.getReportId());
        list.forEach(l -> {
            l.setZan(commentMapper.countZan(l.getId()));
        });
        res.setRecords(list);

        return res;
    }

    @Override
    public BaseRes zanComment(ZanCommentReq zanCommentReq) {
        int count = commentMapper.delZan(zanCommentReq.getId(), zanCommentReq.getUserId());
        if (count == 0) {
            commentMapper.addZan(zanCommentReq.getId(), zanCommentReq.getUserId());
        }

        return new BaseRes();
    }
}
