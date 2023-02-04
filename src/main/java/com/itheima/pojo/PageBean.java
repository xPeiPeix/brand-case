package com.itheima.pojo;

import java.util.List;

/**
 * ClassName: PageBean
 * Package: com.itheima.pojo
 * Description:
 *  分页查询的JavaBean
 * @Author PEIPEI
 * @Create 2023/1/31 22:10
 * @Version 1.0
 */
public class PageBean<T> {
    //总记录数
    private int totalCount;
    //当前页数据
    private List<T> rows;

    public PageBean(List<T> rows, int totalCount) {
        this.rows = rows;
        this.totalCount = totalCount;
    }

    public PageBean() {

    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
