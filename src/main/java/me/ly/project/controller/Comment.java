package me.ly.project.controller;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.ly.project.model.BaseRes;
import me.ly.project.model.CommentModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface Comment {
    @PostMapping("/addComment")
    BaseRes addComment(AddCommentReq addCommentReq);

    @PostMapping("/listComment")
    ListCommentRes listComment(ListCommentReq listCommentReq);

    @PostMapping("/zanComment")
    BaseRes zanComment(ZanCommentReq zanCommentReq);

    @Data @Accessors(chain = true)
    class AddCommentReq{
        private Long reportId;
        private Long userId;
        private String comment;
    }

    @Data @Accessors(chain = true)
    class ListCommentReq {
        private Long reportId;
    }

    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListCommentRes extends BaseRes {
        private List<CommentModel> records;
    }

    @Data @Accessors(chain = true)
    class ZanCommentReq {
        private Long id;
        private Long userId;
    }
}
