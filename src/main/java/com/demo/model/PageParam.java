package com.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 分页查询参数
 */
public class PageParam {

    public static final String ALL_DATA = "1";
    public static final String PAGE_DATA = "2";

    /**
     * 页数
     */
    @NotBlank(message = "页码不能为空")
    @Min(value = 1)
    private Integer pageNum;
    /**
     * 单页大小
     */
    @NotBlank(message = "单页大小不能为空")
    @Min(value = 1)
    private Integer pageSize;

    /**
     * 返回类型：1.所有数据，2.目标页数据（默认）
     */
    private String pageReturnType = PAGE_DATA;

    public PageParam() {
    }

    public PageParam(@NotBlank(message = "页码不能为空") @Min(value = 1) Integer pageNum, @NotBlank(message = "单页大小不能为空") @Min(value = 1) Integer pageSize, String pageReturnType) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageReturnType = pageReturnType;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageReturnType() {
        return pageReturnType;
    }

    public void setPageReturnType(String pageReturnType) {
        this.pageReturnType = pageReturnType;
    }
}
