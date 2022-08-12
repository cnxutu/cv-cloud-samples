package com.clearvision.nacosfeignsample.consumer.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clearvision.common.pojo.vo.PageInfoVO;
import com.clearvision.common.utils.PageUtil;
import com.clearvision.nacosfeignsample.consumer.mapper.TbSchoolDeclareMapper;
import com.clearvision.nacosfeignsample.consumer.pojo.entity.TbSchoolDeclare;
import com.clearvision.nacosfeignsample.consumer.pojo.query.TestQuery;
import com.clearvision.nacosfeignsample.consumer.service.ITbSchoolDeclareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xutu
 * @since 2022-06-28
 */
@Service
public class TbSchoolDeclareServiceImpl extends ServiceImpl<TbSchoolDeclareMapper, TbSchoolDeclare> implements ITbSchoolDeclareService {

    @Resource
    private TbSchoolDeclareMapper schoolDeclareMapper;

//    @Override
//    public PageInfoVO<List<TbSchoolDeclare>> getPageList(TestQuery query) {
//        Page page = new Page(query.getCurrent(), query.getSize());
//        List<TbSchoolDeclare> schoolDeclareList = schoolDeclareMapper.selectPageList(page,query);
//        return PageUtil.pageBuild(page.setRecords(schoolDeclareList));
//    }
}
