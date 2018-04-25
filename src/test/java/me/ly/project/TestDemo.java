package me.ly.project;

import com.google.gson.Gson;
import me.ly.project.Enum.UserType;
import me.ly.project.controller.TestCon;
import me.ly.project.impl.TestConImpl;
import me.ly.project.model.BaseRes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiYan
 * @date 2018/4/25 15:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
    @Autowired
    private TestConImpl testCon;
    @Test
    public void testDemoTest () {
        TestCon.TestConReq testConReq = new TestCon.TestConReq();
        testConReq.setId(1L);
        testConReq.setName("myName");
        testConReq.setUserType(UserType.STUDENT.getValue());
        BaseRes modelBase = testCon.testCon(testConReq);
        System.out.println(new Gson().toJson(modelBase));

    }
}
