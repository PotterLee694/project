package me.ly.project.controller;

import lombok.Data;
import me.ly.project.model.BaseRes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiYan
 * @date 2018/4/25 11:51
 */
@RestController
public interface TestCon {
    @RequestMapping("/testCon")
    BaseRes testCon(TestConReq testConReq);

    @Data
    class TestConReq {
        private Long id;
        private String name;
        private int userType;
    }
}
