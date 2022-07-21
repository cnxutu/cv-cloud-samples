package com.clearvision.mybatissample.service.impl;
import java.util.Date;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clearvision.common.enums.ErrorCodeEnum;
import com.clearvision.common.exception.CustomBusinessException;
import com.clearvision.common.pojo.vo.PageInfoVO;
import com.clearvision.common.pojo.vo.Result;
import com.clearvision.common.utils.PageUtil;
import com.clearvision.mybatissample.entity.TbSchoolDeclare;
import com.clearvision.mybatissample.mapper.TbSchoolDeclareMapper;
import com.clearvision.mybatissample.pojo.query.TestQuery;
import com.clearvision.mybatissample.service.ITbSchoolDeclareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public PageInfoVO<List<TbSchoolDeclare>> getPageList(TestQuery query) {
        Page page = new Page(query.getCurrent(), query.getSize());
        List<TbSchoolDeclare> schoolDeclareList = schoolDeclareMapper.selectPageList(page,query);
        return PageUtil.pageBuild(page.setRecords(schoolDeclareList));
    }

    @Override
    public Result batchInsert() {
//        List<TbSchoolDeclare> list = new ArrayList<>();
//        TbSchoolDeclare tbSchoolDeclare1 = new TbSchoolDeclare();
//        tbSchoolDeclare1 = setAllDeclareSchool(tbSchoolDeclare1);
//        tbSchoolDeclare1.setId(1L);
//        tbSchoolDeclare1.setSchoolName("王炸学校1");
//        tbSchoolDeclare1.setBelongArea("天堂镇1");
//
//        TbSchoolDeclare tbSchoolDeclare2 = new TbSchoolDeclare();
//        tbSchoolDeclare2 = setAllDeclareSchool(tbSchoolDeclare2);
//        tbSchoolDeclare2.setId(2L);
//        tbSchoolDeclare2.setSchoolName("王炸学校2");
//        tbSchoolDeclare2.setBelongArea("天堂镇2");
//
//        TbSchoolDeclare tbSchoolDeclare3 = new TbSchoolDeclare();
//        tbSchoolDeclare3 = setAllDeclareSchool(tbSchoolDeclare3);
//        tbSchoolDeclare3.setId(3L);
//        tbSchoolDeclare3.setSchoolName("王炸学校3");
//        tbSchoolDeclare3.setBelongArea("天堂镇3");
//        list.add(tbSchoolDeclare1);
//        list.add(tbSchoolDeclare2);
//        list.add(tbSchoolDeclare3);
//        int i = schoolDeclareMapper.insertBatchSomeColumn(list);
//        if (i < 1){
//            throw new CustomBusinessException(ErrorCodeEnum.OPERATION_FAIL);
//        }
        return Result.succeed();
    }

    private TbSchoolDeclare setAllDeclareSchool(TbSchoolDeclare tbSchoolDeclare1) {
        TbSchoolDeclare tbSchoolDeclare = new TbSchoolDeclare();
        tbSchoolDeclare.setSchoolName("");
        tbSchoolDeclare.setBelongArea("");
        tbSchoolDeclare.setPrefxInclude("");
        tbSchoolDeclare.setOrgProperty(0);
        tbSchoolDeclare.setSchoolType(0);
        tbSchoolDeclare.setUrbanRuralAttributes(0);
        tbSchoolDeclare.setSchoolLevel(0);
        tbSchoolDeclare.setProvinceId(0);
        tbSchoolDeclare.setProvince("");
        tbSchoolDeclare.setCityId(0);
        tbSchoolDeclare.setCity("");
        tbSchoolDeclare.setRegionId(0);
        tbSchoolDeclare.setRegion("");
        tbSchoolDeclare.setSchoolCode("");
        tbSchoolDeclare.setSchoolAttribute(0);
        tbSchoolDeclare.setSchoolAddress("");
        tbSchoolDeclare.setRefuseReason("");
        tbSchoolDeclare.setSchoolDeclareState(0);
        tbSchoolDeclare.setLng("");
        tbSchoolDeclare.setLat("");
        tbSchoolDeclare.setReporter(0L);
        tbSchoolDeclare.setReportTime(LocalDateTime.now());
        tbSchoolDeclare.setReporterPhone("");
        tbSchoolDeclare.setRemark("");
        tbSchoolDeclare.setContactPerson("");
        tbSchoolDeclare.setContactPersonPhone("");
        tbSchoolDeclare.setCreateTime(LocalDateTime.now());
        tbSchoolDeclare.setUpdateTime(LocalDateTime.now());
        tbSchoolDeclare.setStreet("");
        tbSchoolDeclare.setCommunity("");
        tbSchoolDeclare.setSocialCreditCode("");
        tbSchoolDeclare.setIsMainCampus(0);
        tbSchoolDeclare.setBranchCampusScCode("");
        tbSchoolDeclare.setSchoolHoldType(0);
        tbSchoolDeclare.setOrganizersType(0);
        tbSchoolDeclare.setParentId(0L);
        tbSchoolDeclare.setId(0L);
        tbSchoolDeclare.setCreateTime(new Date());
        tbSchoolDeclare.setUpdateTime(new Date());
        tbSchoolDeclare.setCreator(0L);
        tbSchoolDeclare.setOperator(0L);
        tbSchoolDeclare.setIsDeleted(0);
        return tbSchoolDeclare;
    }
}
