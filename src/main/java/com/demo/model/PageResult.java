package com.demo.model;

import java.util.List;

/**
 * 分页数据
 */
public class PageResult {

    /**
     * 当前页数：可能因为查询页数超过最大页数而重置
     */
    private Integer currentPage;

    /**
     * 最大页数
     */
    private Integer maxPage;

    /**
     * 列表数据
     */
    private List<?> data;

    public PageResult() {
    }

    public PageResult(Integer currentPage, List<?> data) {
        this.currentPage = currentPage;
        this.data = data;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
