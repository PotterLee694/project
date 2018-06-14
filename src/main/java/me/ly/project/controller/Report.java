package me.ly.project.controller;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.ly.project.model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface Report {

    @PostMapping("/addReport")
    BaseRes addReport(AddReportReq addReportReq);

    @PostMapping("/listReport")
    ListReportRes listReport(ListReportReq listReportReq);

    @PostMapping("/listNeedReport")
    ListNeedReportRes listNeedReport(ListNeedReportReq listNeedReportReq);

    @PostMapping("/getReport")
    QueryReportRes queryReport(QueryReportReq queryReportReq);

    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class AddReportReq {
        private Long courseId;
        private Long templateId;
        private Long userId;
        private String answer;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListReportReq extends PageReq {
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListReportRes extends PageRes {
        private List<ReportInfo> records;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ReportInfo {
        private Long id;
        private String title;
        private String stuName;
        private String createStamp;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListNeedReportReq extends PageReq{
        private Long userId;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListNeedReportRes extends PageRes {
        private List<CourseModel> records;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class QueryReportReq {
        private Long id;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class QueryReportRes extends BaseRes{
        private ReportModel report;
        private Double avgScore;
    }
}
