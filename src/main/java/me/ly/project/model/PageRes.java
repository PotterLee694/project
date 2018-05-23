package me.ly.project.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class PageRes extends BaseRes{
    private Page page;

    public Page setPage(Page page) {
        this.page = page;
        return this.page;
    }

}
