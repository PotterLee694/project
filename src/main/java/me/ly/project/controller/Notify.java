package me.ly.project.controller;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.ly.project.model.BaseRes;
import me.ly.project.model.NoticeModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface Notify {

    @PostMapping("/addNotice")
    BaseRes addNotice(AddNoticeReq addNoticeReq);

    @PostMapping("/listNewNotice")
    ListNoticeRes listNewNotice(ListNoticeReq listNoticeReq);

    @PostMapping("/listNotice")
    ListNoticeRes listNotice(ListNoticeReq listNoticeReq);

    @PostMapping("/checkNotice")
    BaseRes checkNotice(CheckNoticeReq checkNoticeReq);

    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class AddNoticeReq {
        private Long userId;
        private String type;
        private String content;
    }

    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListNoticeReq {
        private Long userId;
        private String type;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListNoticeRes {
        private List<NoticeModel> records;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class CheckNoticeReq {
        private Long userId;
        private String type;
    }


}
