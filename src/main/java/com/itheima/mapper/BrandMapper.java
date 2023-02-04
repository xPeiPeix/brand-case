package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
    * @description 添加数据
    * @param brand
    * @return void
    * @author PEIPEI
    * @date 2023/1/30 21:03
    */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName}," +
            "#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
    * @description 批量删除
    * @param ids
    * @return void
    * @author PEIPEI
    * @date 2023/1/31 21:39
    */
    void deleteByIds(@Param("ids") int[] ids);


    /**
    * @description 分页查询
    * @param begin
     * @param size
    * @return java.util.List<com.itheima.pojo.Brand>
    * @author PEIPEI
    * @date 2023/1/31 22:31
    */
    @Select("select * from tb_brand limit #{begin},#{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
    * @description TODO
    * 查询总记录数
    * @return int
    * @author PEIPEI
    * @date 2023/2/1 20:54
    */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();


    /**
    * @description 分页条件查询
    * @param begin
     * @param size
    * @return java.util.List<com.itheima.pojo.Brand>
    * @author PEIPEI
    * @date 2023/2/4 14:20
    */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
    * @description 根据条件查询总记录数
    * @param brand
    * @return int
    * @author PEIPEI
    * @date 2023/2/4 14:21
    */
    int selectTotalCountByCondition(Brand brand);

}
