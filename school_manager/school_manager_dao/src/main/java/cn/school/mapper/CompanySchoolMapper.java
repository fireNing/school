package cn.school.mapper;

import cn.school.pojo.CompanySchool;
import cn.school.pojo.CompanySchoolExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanySchoolMapper {
    int countByExample(CompanySchoolExample example);

    int deleteByExample(CompanySchoolExample example);

    int insert(CompanySchool record);

    int insertSelective(CompanySchool record);

    List<CompanySchool> selectByExample(CompanySchoolExample example);

    int updateByExampleSelective(@Param("record") CompanySchool record, @Param("example") CompanySchoolExample example);

    int updateByExample(@Param("record") CompanySchool record, @Param("example") CompanySchoolExample example);
}