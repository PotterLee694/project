package me.ly.project.controller;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.ly.project.model.BaseRes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface Score {

    @PostMapping("/updateScore")
    BaseRes updateScore(UpdateScoreReq updateScoreReq);

    @PostMapping("/getScore")
    QueryScoreRes queryScore(QueryScoreReq queryScoreReq);

    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class UpdateScoreReq {
        private Long userId;
        private Long reportId;
        private Integer score;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class QueryScoreReq {
        private Long userId;
        private Long reportId;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class QueryScoreRes extends BaseRes {
        private Integer score;
    }
}
