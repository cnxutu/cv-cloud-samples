package com.clearvision.mybatissample.service;

import com.clearvision.common.pojo.vo.PageInfoVO;
import com.clearvision.common.pojo.vo.Result;
import com.clearvision.mybatissample.entity.TbSchoolDeclare;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clearvision.mybatissample.pojo.query.TestQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xutu
 * @since 2022-06-28
 */
public interface ITbSchoolDeclareService extends IService<TbSchoolDeclare> {

    PageInfoVO<List<TbSchoolDeclare>> getPageList(TestQuery query);

    Result batchInsert();

}
