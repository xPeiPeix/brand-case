package com.itheima.Service.impl;

import com.itheima.Service.BrandService;
import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * ClassName: BrandServiceImpl
 * Package: com.itheima.Service.impl
 * Description:
 *
 * @Author PEIPEI
 * @Create 2023/1/29 16:32
 * @Version 1.0
 */
public class BrandServiceImpl implements BrandService {

    //1、创建SqlSessionFactory工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //计算索引
        int begin = (currentPage - 1) * pageSize;
        //计算查询条目数
        int size = pageSize;
        //查询当前页数据
        List<Brand> rows = mapper.selectByPage(begin, size);
        //查询总记录数
        int totalCount = mapper.selectTotalCount();
        //封装pageBean对象
        PageBean<Brand> pageBean = new PageBean<>(rows,totalCount);

        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //计算索引
        int begin = (currentPage - 1) * pageSize;
        //计算查询条目数
        int size = pageSize;
        //处理brand条件，like模糊匹配表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        //处理brand条件，like模糊匹配表达式
        String CompanyName = brand.getCompanyName();
        if (CompanyName != null && CompanyName.length() > 0) {
            brand.setCompanyName("%" + CompanyName + "%");
        }

        //查询当前页数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);
        //查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brand);
        //封装pageBean对象
        PageBean<Brand> pageBean = new PageBean<>(rows,totalCount);

        sqlSession.close();
        return pageBean;
    }

    @Override
    public List<Brand> selectAll() {
        //2、获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3、获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4、调用方法
        List<Brand> brands = mapper.selectAll();
        //5、释放资源
        sqlSession.close();

        return brands;
    }
}
