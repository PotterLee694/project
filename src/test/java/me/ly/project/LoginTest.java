package me.ly.project;

import com.google.gson.Gson;
import me.ly.project.controller.Login;
import me.ly.project.impl.LoginImpl;
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
public class LoginTest {
    @Autowired
    private LoginImpl login;
    @Test
    public void loginTest() {
        Login.LoginReq loginReq = new Login.LoginReq();
        loginReq.setStuNo(2014133019L);
        loginReq.setPassword("123456");

        Login.LoginRes loginRes = this.login.login(loginReq);

        System.out.println(new Gson().toJson(loginRes));

    }
}
