package me.ly.project.impl;

import me.ly.project.Enum.EnumUtil;
import me.ly.project.Enum.UserType;
import me.ly.project.controller.TestCon;
import me.ly.project.model.ModelBase;
import org.springframework.stereotype.Service;

/**
 * @author LiYan
 * @date 2018/4/25 11:55
 */
@Service
public class TestConImpl implements TestCon{
    @Override
    public ModelBase testCon(TestConReq testConReq) {
        return new ModelBase().setContent("id:" + testConReq.getId() + ", name:" + testConReq.getName()
                                                  + ", userType:" + EnumUtil.getEnum(UserType.class, testConReq.getUserType()));
    }

}
