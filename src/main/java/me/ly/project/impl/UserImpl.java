package me.ly.project.impl;

import com.sun.corba.se.spi.ior.ObjectKey;
import me.ly.project.Enum.AppError;
import me.ly.project.controller.User;
import me.ly.project.mapper.UserAccountMapper;
import me.ly.project.mapper.UserMapper;
import me.ly.project.model.BaseRes;
import me.ly.project.model.UserAccountModel;
import me.ly.project.model.UserModel;
import me.ly.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author LiYan
 * @date 2018/4/24 0:38
 */
@Service
public class UserImpl implements User {
    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Override
    public LoginRes login(LoginReq loginReq) {
        LoginRes loginRes = new LoginRes();

        Long stuNo;
        try {
            stuNo = Long.parseLong(loginReq.getStuNo());
        } catch (NumberFormatException e) {
            loginRes.setBaseRes(AppError.STUNO_ERROR);
            return loginRes;
        }
        UserAccountModel userAccountModel = userAccountMapper.check(stuNo, loginReq.getPassword());
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

    @Override
    public UpdateUserInfoRes updateUserInfo(UpdateUserInfoReq updateUserInfoReq) {
        UpdateUserInfoRes updateUserInfoRes = new UpdateUserInfoRes();
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", updateUserInfoReq.getId());
        params.put("userName", updateUserInfoReq.getUserName());
        params.put("iconUrl", updateUserInfoReq.getIconUrl());
        int count = userMapper.updateBy(params);
        if (count <= 0) {
            updateUserInfoRes.setBaseRes(AppError.UPDATE_ERROR);
        }
        UserModel userModel = userMapper.queryById(updateUserInfoReq.getId());
        return updateUserInfoRes.setUser(userModel);
    }

}
