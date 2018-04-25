package me.ly.project.impl;

import me.ly.project.controller.Login;
import me.ly.project.mapper.UserAccountMapper;
import me.ly.project.model.ModelBase;
import me.ly.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiYan
 * @date 2018/4/24 0:38
 */
@Service
public class LoginImpl implements Login {
    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private UserService userService;
    @Override
    public LoginRes login(LoginReq loginReq) {
        LoginRes loginRes = new LoginRes();
        int count = userAccountMapper.check(loginReq.getStuNo(), loginReq.getPassword());
        if (count < 1) {
        } else {
            loginRes.setUser(userService.getUserInfo(loginReq.getStuNo()));
        }
        return loginRes;
    }

    @Override
    public ModelBase loginOut(LoginOutReq loginOutReq) {
        ModelBase modelBase = new ModelBase();
        return modelBase;
    }
}
