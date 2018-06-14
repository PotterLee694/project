package me.ly.project.impl;

import me.ly.project.controller.Score;
import me.ly.project.mapper.ScoreMapper;
import me.ly.project.model.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreImpl implements Score {
    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public BaseRes updateScore(UpdateScoreReq updateScoreReq) {
        int count = scoreMapper.countRecord(updateScoreReq.getUserId(), updateScoreReq.getReportId());
        if (count > 0) {
            scoreMapper.update(updateScoreReq.getUserId(), updateScoreReq.getReportId(), updateScoreReq.getScore());
        } else {
            scoreMapper.insert(updateScoreReq.getUserId(), updateScoreReq.getReportId(), updateScoreReq.getScore());
        }

        return new BaseRes();
    }

    @Override
    public QueryScoreRes queryScore(QueryScoreReq queryScoreReq) {
        Integer score = scoreMapper.getScore(queryScoreReq.getUserId(), queryScoreReq.getReportId());
        return new QueryScoreRes().setScore(score);
    }
}
