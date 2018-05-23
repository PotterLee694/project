package me.ly.project.controller;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.ly.project.model.BaseRes;
import me.ly.project.model.UserModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiYan
 * @date 2018/4/23 22:52
 */
@RestController()
public interface Login {

    @PostMapping("/login")
    LoginRes login(LoginReq loginReq);
    @RequestMapping("/loginOut")
    BaseRes loginOut(LoginOutReq loginOutReq);

    @Data
    @Accessors(chain = true)
    class LoginReq {
        private Long stuNo;
        private String password;
    }
    @Data
    @Accessors(chain = true)
    @ToString(callSuper = true)
    class LoginRes extends BaseRes {
        private UserModel user;
    }
    @Data
    @Accessors(chain = true)
    class LoginOutReq {
        private int id;
    }
}
