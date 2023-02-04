package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * ClassName: BaseServlet
 * Package: com.itheima.web
 * Description:
 *
 * @Author PEIPEI
 * @Create 2023/1/30 21:32
 * @Version 1.0
 */
public class BaseServlet extends HttpServlet {
    /**
     * @description
     * 根据请求的最后一段路径来进行方法分发
     * HttpServlet类 - service方法分发给doGet、doPost等方法，重写后请求不会进入doGet、doPost方法
     * @param req
     * @param resp
     * @return void
     * @author PEIPEI
     * @date 2023/1/30 21:33
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求路径，例如： /brand-case/brand/selectAll
        String uri = req.getRequestURI();
        //2、获取最后一段路径
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);

        //3、执行方法
        Class<? extends BaseServlet> c = this.getClass();
        try {
            Method method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
