package me.ly.project.controller;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.ly.project.model.BaseRes;
import me.ly.project.model.PageReq;
import me.ly.project.model.PageRes;
import me.ly.project.model.TemplateModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface Template {
    @PostMapping("/listTemplate")
    ListTemplateRes listTemplate(ListTemplateReq listTemplateReq);

    @PostMapping("/updateTemplate")
    BaseRes updateTemplate(UpdateTemplateReq updateTemplateReq);

    @PostMapping("/getTemplate")
    QueryTemplateRes queryTemplate(QueryTemplateReq queryTemplateReq);

    @PostMapping("/delTemplate")
    BaseRes delTemplate(DelTemplateReq delTemplateReq);


    @Data @Accessors(chain = true)
    class ListTemplateReq extends PageReq{
        private Long userId;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class ListTemplateRes extends PageRes {
        private List<TemplateModel> records;
    }

    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class UpdateTemplateReq {
        private Long id;
        private Long owner;
        private String title;
        private String template;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class UpdateTemplateRes extends BaseRes {
        private TemplateModel template;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class QueryTemplateReq {
        private Long id;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class QueryTemplateRes extends BaseRes{
        private TemplateModel template;
    }
    @Data @Accessors(chain = true) @ToString(callSuper = true)
    class DelTemplateReq {
        private Long id;
    }






}

