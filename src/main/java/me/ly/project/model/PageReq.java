package me.ly.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PageReq {
    private Page page;

    public Page getThePage() {
        if (this.page == null) {
            return null;
        }
        int pageNum = this.page.getPageNum();
        int pageSize = this.page.getPageSize();
        this.page.setOffset((pageNum - 1) * pageSize);
        return this.page;
    }
}
