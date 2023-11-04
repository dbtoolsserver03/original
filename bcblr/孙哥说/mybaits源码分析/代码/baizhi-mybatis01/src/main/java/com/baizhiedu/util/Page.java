package com.baizhiedu.util;

/**
 * 目的 封装分页相关操作
 * pageIndex 页号
 * web 前端传递
 * pageCount 每页显示多少条
 * 写死 3
 * totalSize 总共有多少条
 * count(*) 算出来
 * <p>
 * *    pageSize  一共有多少页
 * totalSize / pageCount
 * 6 / 3 = 2
 * 7 / 3 = 3
 */
public class Page {
    private Integer pageIndex;
    private Integer pageCount;
    //查询数据库的
    //sql语句相关
    //计算在哪里完成？ 拦截器操作
    private Integer totalSize;
    private Integer pageSize;

    public Page(Integer pageIndex) {
        this.pageIndex = pageIndex;
        this.pageCount = 5;
    }

    public Page(Integer pageIndex, Integer pageCount) {
        this.pageIndex = pageIndex;
        this.pageCount = pageCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
        if (totalSize % pageCount == 0) {
            this.pageSize = totalSize / pageCount;
        } else {
            this.pageSize = totalSize / pageCount + 1;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    // limit getFirstItem,pageSize;
    public Integer getFirstItem() {
        return pageIndex - 1;
    }
}
