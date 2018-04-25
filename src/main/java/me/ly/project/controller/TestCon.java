package me.ly.project.controller;

import lombok.Data;
import me.ly.project.Enum.UserType;
import me.ly.project.model.ModelBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiYan
 * @date 2018/4/25 11:51
 */
@RestController
public interface TestCon {
    @RequestMapping("/testCon")
    ModelBase testCon(TestConReq testConReq);

    @Data
    class TestConReq {
        private Long id;
        private String name;
        private int userType;
    }
}
