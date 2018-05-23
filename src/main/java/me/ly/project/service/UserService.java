package me.ly.project.service;

import me.ly.project.mapper.UserMapper;
import me.ly.project.model.UserAccountModel;
import me.ly.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiYan
 * @date 2018/4/24 1:50
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户信息
     * @param userAccountModel 学号
     * @return 获取的用户信息
     */
    public UserModel getUserInfo(UserAccountModel userAccountModel) {
        UserModel userModel = userMapper.queryByStuNo(userAccountModel.getStuNo());
        if (userModel == null) {
            userModel = registerUser(userAccountModel);
        }
        return userModel;
    }

    private UserModel registerUser(UserAccountModel userAccountModel) {
        UserModel userModel = new UserModel();
        userModel.setStuNo(userAccountModel.getStuNo()).setUserType(userAccountModel.getUserType());
        userMapper.insert(userModel);
        // TODO: 2018/4/24 自动把主键转入userModel
        return userModel;
    }


}
