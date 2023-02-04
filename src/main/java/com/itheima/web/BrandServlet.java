package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.Service.BrandService;
import com.itheima.Service.impl.BrandServiceImpl;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.List;

/**
 * ClassName: BrandServlet
 * Package: com.itheima.web
 * Description:
 *
 * @Author PEIPEI
 * @Create 2023/1/30 21:33
 * @Version 1.0
 */
@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、调用service查询
        List<Brand> brands = brandService.selectAll();
        //2、转为JSON
        String jsonString = JSON.toJSONString(brands);
        //3、写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、接收品牌数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        //2、调用service添加
        brandService.add(brand);
        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、接收数据 json
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转为int[]
        int[] ids = JSON.parseObject(params, int[].class);
        //2、调用service删除
        brandService.deleteByIds(ids);
        resp.getWriter().write("success");

    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、接收数据 当前页码和每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //2、调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        //3、转为JSON
        String jsonString = JSON.toJSONString(pageBean);

        //4、写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);

    }

    /**
    * @description 分页条件查询
    * @param req 
     * @param resp
    * @return void
    * @author PEIPEI
    * @date 2023/2/4 15:03
    */
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、接收数据 当前页码和每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader br = req.getReader();
        String params = br.readLine();

        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //2、调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);

        //3、转为JSON
        String jsonString = JSON.toJSONString(pageBean);

        //4、写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
