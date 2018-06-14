package me.ly.project.impl;

import me.ly.project.controller.Template;
import me.ly.project.mapper.TemplateMapper;
import me.ly.project.model.BaseRes;
import me.ly.project.model.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateImpl implements Template {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public ListTemplateRes listTemplate(ListTemplateReq listTemplateReq) {
        ListTemplateRes res = new ListTemplateRes();

        List<TemplateModel> templateModels = templateMapper.queryTemplates(listTemplateReq.getUserId(), listTemplateReq.getThePage());
        templateModels.forEach(templateModel -> {
            templateModel.setCourseMapped(templateMapper.getMappedCourseName(templateModel.getId()));
        });
        if (listTemplateReq.getThePage() != null) {
            int count = templateMapper.queryTemplateCount(listTemplateReq.getUserId(), listTemplateReq.getThePage());
            res.setPage(listTemplateReq.getThePage().setTotalCount(count));
        }

        res.setRecords(templateModels);

        return res;
    }

    @Override
    public UpdateTemplateRes updateTemplate(UpdateTemplateReq updateTemplateReq) {
        UpdateTemplateRes res = new UpdateTemplateRes();

        TemplateModel reqModel = new TemplateModel().setId(updateTemplateReq.getId())
                                                    .setTitle(updateTemplateReq.getTitle())
                                                    .setTemplate(updateTemplateReq.getTemplate())
                                                    .setOwner(updateTemplateReq.getOwner());

        if (reqModel.getId() == null || reqModel.getId().equals(0L)) {
            int count = templateMapper.insert(reqModel);
            if (count <= 0) {
                res.setSuccess(false);
            } else {
                res.setTemplate(reqModel);
            }
        } else {
            int count = templateMapper.update(reqModel);
            if (count <= 0) {
                res.setSuccess(false);
            } else {
                res.setTemplate(templateMapper.getTemplate(reqModel.getId()));
            }
        }
        return res;
    }

    @Override
    public QueryTemplateRes queryTemplate(QueryTemplateReq queryTemplateReq) {
        TemplateModel template = templateMapper.getTemplate(queryTemplateReq.getId());
        return new QueryTemplateRes().setTemplate(template);
    }

    @Override
    public BaseRes delTemplate(DelTemplateReq delTemplateReq) {
        templateMapper.delete(delTemplateReq.getId());
        return new BaseRes();
    }
}
