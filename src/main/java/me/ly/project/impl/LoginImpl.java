package me.ly.project.impl;

import lombok.extern.slf4j.Slf4j;
import me.ly.project.Enum.AppError;
import me.ly.project.controller.Login;
import me.ly.project.mapper.UserAccountMapper;
import me.ly.project.model.BaseRes;
import me.ly.project.model.UserAccountModel;
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

        UserAccountModel userAccountModel = userAccountMapper.check(loginReq.getStuNo(), loginReq.getPassword());
        if (userAccountModel == null) {
            loginRes.setBaseRes(AppError.LOGIN_FAILED);
        } else {
            loginRes.setUser(userService.getUserInfo(userAccountModel));
        }
        return loginRes;
    }

    @Override
    public BaseRes loginOut(LoginOutReq loginOutReq) {
        BaseRes baseRes = new BaseRes();
        baseRes.setBaseRes(AppError.SUCCESS);
        return baseRes;
    }
}
