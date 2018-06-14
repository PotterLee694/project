package me.ly.project.impl;

import me.ly.project.controller.Report;
import me.ly.project.mapper.*;
import me.ly.project.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportImpl implements Report {
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private NotifyMapper notifyMapper;

    @Override
    public BaseRes addReport(AddReportReq addReportReq) {
        reportMapper.insert(new ReportModel().setCourseId(addReportReq.getCourseId())
                                             .setTemplateId(addReportReq.getTemplateId())
                                             .setUserId(addReportReq.getUserId())
                                             .setAnswer(addReportReq.getAnswer()));

        CourseModel course = courseMapper.getCourse(addReportReq.getCourseId());
        UserModel user = userMapper.queryById(addReportReq.getUserId());
        StringBuffer content = new StringBuffer();
        content.append(user.getUserName())
               .append("提交了课程：")
               .append(course.getTitle())
               .append("的实验报告");
        notifyMapper.insert(new NoticeModel().setType("newReport")
                                             .setUserId(course.getOwner())
                                             .setContent(content.toString()));

        return new BaseRes();
    }

    @Override
    public ListReportRes listReport(ListReportReq listReportReq) {
        ListReportRes res = new ListReportRes();
        List<ReportModel> reportModels = reportMapper.listReports(listReportReq.getThePage());
        List<ReportInfo> list = new ArrayList<>();
        reportModels.forEach(reportModel -> {
            list.add(new ReportInfo().setId(reportModel.getId())
                                     .setCreateStamp(reportModel.getCreateStamp())
                                     .setStuName(userMapper.queryById(reportModel.getUserId()).getUserName())
                                     .setTitle(courseMapper.getCourse(reportModel.getCourseId()).getTitle()));

        });
        int count = reportMapper.queryReportCount(listReportReq.getThePage());
        res.setPage(listReportReq.getThePage().setTotalCount(count));
        res.setRecords(list);

        return res;
    }

    @Override
    public ListNeedReportRes listNeedReport(ListNeedReportReq listNeedReportReq) {
        List<CourseModel> list = reportMapper.listNeedReport(listNeedReportReq.getUserId(), listNeedReportReq.getThePage());
//        List<CourseModel> collect = list.stream()
//                                        .filter(courseModel -> reportMapper.findReport(listNeedReportReq.getUserId(), courseModel.getId()) == null)
//                                        .collect(Collectors.toList());
        int count = reportMapper.queryNeedReportCount(listNeedReportReq.getUserId(), listNeedReportReq.getThePage());

        ListNeedReportRes res = new ListNeedReportRes();
        res.setRecords(list);
        res.setPage(listNeedReportReq.getThePage().setTotalCount(count));

        return res;
    }

    @Override
    public QueryReportRes queryReport(QueryReportReq queryReportReq) {
        ReportModel reportModel = reportMapper.queryReport(queryReportReq.getId());
        Double avgScore = scoreMapper.getAvgScore(queryReportReq.getId());
        return new QueryReportRes().setReport(reportModel).setAvgScore(avgScore);
    }
}
