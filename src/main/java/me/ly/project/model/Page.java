package me.ly.project.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Page {
    private int pageNum;
    private int pageSize;
    private int offset;
    private int totalCount;
    private int pageCount;

    private String order;
    private Boolean desc;

    private String searchType;
    private String searchContent;

    public Page setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.pageCount = totalCount / this.pageSize;
        if (totalCount % this.pageSize > 0) {
            this.pageCount ++;
        }
        return this;

    }
}
