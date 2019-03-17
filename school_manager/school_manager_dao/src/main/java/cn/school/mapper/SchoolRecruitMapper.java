package cn.school.mapper;

import cn.school.pojo.SchoolRecruit;
import cn.school.pojo.SchoolRecruitExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchoolRecruitMapper {
    int countByExample(SchoolRecruitExample example);

    int deleteByExample(SchoolRecruitExample example);

    int deleteByPrimaryKey(String sid);

    int insert(SchoolRecruit record);

    int insertSelective(SchoolRecruit record);

    List<SchoolRecruit> selectByExample(SchoolRecruitExample example);

    SchoolRecruit selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") SchoolRecruit record, @Param("example") SchoolRecruitExample example);

    int updateByExample(@Param("record") SchoolRecruit record, @Param("example") SchoolRecruitExample example);

    int updateByPrimaryKeySelective(SchoolRecruit record);

    int updateByPrimaryKey(SchoolRecruit record);
}