package me.ly.project.impl;

import me.ly.project.controller.Notify;
import me.ly.project.mapper.NotifyMapper;
import me.ly.project.model.BaseRes;
import me.ly.project.model.NoticeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotifyImpl implements Notify {
    @Autowired
    private NotifyMapper notifyMapper;
    @Override
    public BaseRes addNotice(AddNoticeReq addNoticeReq) {
        notifyMapper.insert(new NoticeModel().setUserId(addNoticeReq.getUserId())
                                             .setType(addNoticeReq.getType())
                                             .setContent(addNoticeReq.getContent()));

        return new BaseRes();
    }

    @Override
    public ListNoticeRes listNewNotice(ListNoticeReq listNoticeReq) {
        ListNoticeRes res = new ListNoticeRes();
        List<NoticeModel> noticeModels = notifyMapper.listNewNotice(listNoticeReq.getUserId(), listNoticeReq.getType());
        res.setRecords(noticeModels);
        //记录检查时间
        notifyMapper.checkNotice(listNoticeReq.getUserId(), listNoticeReq.getType());

        return res;
    }

    @Override
    public ListNoticeRes listNotice(ListNoticeReq listNoticeReq) {
        ListNoticeRes res = new ListNoticeRes();
        List<NoticeModel> noticeModels = notifyMapper.listNotice(listNoticeReq.getUserId(), listNoticeReq.getType());
        res.setRecords(noticeModels);

        return res;
    }

    @Override
    public BaseRes checkNotice(CheckNoticeReq checkNoticeReq) {
        notifyMapper.checkNotice(checkNoticeReq.getUserId(), checkNoticeReq.getType());
        return new BaseRes();
    }
}
