package me.ly.project.impl;

import me.ly.project.util.EnumUtil;
import me.ly.project.Enum.UserType;
import me.ly.project.controller.TestCon;
import me.ly.project.model.BaseRes;
import org.springframework.stereotype.Service;

/**
 * @author LiYan
 * @date 2018/4/25 11:55
 */
@Service
public class TestConImpl implements TestCon{
    @Override
    public BaseRes testCon(TestConReq testConReq) {
        return new BaseRes().setContent("id:" + testConReq.getId() + ", name:" + testConReq.getName()
                                                  + ", userType:" + EnumUtil.getEnum(UserType.class, testConReq.getUserType()));
    }

}
