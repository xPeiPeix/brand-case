package com.itheima.Service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

/**
 * ClassName: BrandService
 * Package: com.itheima.Service
 * Description:
 *
 * @Author PEIPEI
 * @Create 2023/1/29 16:26
 * @Version 1.0
 */
public interface BrandService {

    /**
    * @description 查询所有
    *
    * @return java.util.List<com.itheima.pojo.Brand>
    * @author PEIPEI
    * @date 2023/1/29 16:30
    */
    List<Brand>  selectAll();

    /**
    * @description 添加数据
    * @param brand
    * @return void
    * @author PEIPEI
    * @date 2023/1/30 21:10
    */
    void add(Brand brand);

    /**
    * @description 批量删除
    * @param ids
    * @return void
    * @author PEIPEI
    * @date 2023/1/31 21:46
    */
    void deleteByIds(int[] ids);

    /**
    * @description 分页查询
    * @param currentPage  当前页码
     * @param pageSize  每页展示条数
    * @return com.itheima.pojo.PageBean<com.itheima.pojo.Brand>
    * @author PEIPEI
    * @date 2023/1/31 22:36
    */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
    * @description 分页条件查询
    * @param currentPage
     * @param pageSize
     * @param brand
    * @return com.itheima.pojo.PageBean<com.itheima.pojo.Brand>
    * @author PEIPEI
    * @date 2023/2/4 14:52
    */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);

}
