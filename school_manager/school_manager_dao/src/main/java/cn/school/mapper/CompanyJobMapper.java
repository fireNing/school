package cn.school.mapper;

import cn.school.pojo.CompanyJobExample;
import cn.school.pojo.CompanyJobKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyJobMapper {
    int countByExample(CompanyJobExample example);

    int deleteByExample(CompanyJobExample example);

    int deleteByPrimaryKey(CompanyJobKey key);

    int insert(CompanyJobKey record);

    int insertSelective(CompanyJobKey record);

    List<CompanyJobKey> selectByExample(CompanyJobExample example);

    int updateByExampleSelective(@Param("record") CompanyJobKey record, @Param("example") CompanyJobExample example);

    int updateByExample(@Param("record") CompanyJobKey record, @Param("example") CompanyJobExample example);
}