package me.ly.project.service;

import lombok.extern.slf4j.Slf4j;
import me.ly.project.mapper.CourseMapper;
import me.ly.project.mapper.LikeMapper;
import me.ly.project.mapper.NotifyMapper;
import me.ly.project.model.CourseModel;
import me.ly.project.model.NoticeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseStatusUpdater {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private NotifyMapper notifyMapper;
    @Autowired
    private LikeMapper likeMapper;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void doUpdater() {
        List<CourseModel> courseModels = courseMapper.queryOverCourses();
        courseModels.forEach(courseModel -> {
            courseMapper.update(new CourseModel().setId(courseModel.getId())
                                                 .setCourseOver(true));
            List<Long> likers = likeMapper.queryLiker(courseModel.getId());
            likers.forEach(liker -> {
                StringBuffer content = new StringBuffer();
                content.append("您关注的课程：")
                       .append(courseModel.getTitle())
                       .append(" 已结束，请及时填写实验报告");
                notifyMapper.insert(new NoticeModel().setType("needReport")
                                                     .setUserId(liker)
                                                     .setContent(content.toString()));
            });
        });


        log.info("updateCourseStatus :{} ", courseModels);
    }
}
