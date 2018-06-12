package me.ly.project;

import com.google.gson.Gson;
import me.ly.project.controller.User;
import me.ly.project.impl.UserImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiYan
 * @date 2018/4/24 2:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserImpl login;
    @Test
    public void loginTest() {
        User.LoginReq loginReq = new User.LoginReq();
        loginReq.setStuNo("123");
        loginReq.setPassword("123");

        User.LoginRes loginRes = this.login.login(loginReq);

        System.out.println(new Gson().toJson(loginRes));

    }
}
