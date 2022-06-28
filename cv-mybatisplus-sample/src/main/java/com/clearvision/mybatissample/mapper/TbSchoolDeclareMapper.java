package com.clearvision.mybatissample.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clearvision.mybatissample.entity.TbSchoolDeclare;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clearvision.mybatissample.pojo.query.TestQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xutu
 * @since 2022-06-28
 */
public interface TbSchoolDeclareMapper extends BaseMapper<TbSchoolDeclare> {

    List<TbSchoolDeclare> selectPageList(Page page, @Param("query") TestQuery query);
}
