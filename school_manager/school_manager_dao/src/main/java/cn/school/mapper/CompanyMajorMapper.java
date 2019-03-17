package cn.school.mapper;

import cn.school.pojo.CompanyMajor;
import cn.school.pojo.CompanyMajorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMajorMapper {
    int countByExample(CompanyMajorExample example);

    int deleteByExample(CompanyMajorExample example);

    int insert(CompanyMajor record);

    int insertSelective(CompanyMajor record);

    List<CompanyMajor> selectByExample(CompanyMajorExample example);

    int updateByExampleSelective(@Param("record") CompanyMajor record, @Param("example") CompanyMajorExample example);

    int updateByExample(@Param("record") CompanyMajor record, @Param("example") CompanyMajorExample example);
}