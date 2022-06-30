package com.clearvision.mybatissample.controller;
import java.util.Date;
import java.time.LocalDateTime;

import com.clearvision.common.enums.ErrorCodeEnum;
import com.clearvision.common.exception.CustomBusinessException;
import com.clearvision.common.pojo.vo.PageInfoVO;
import com.clearvision.common.pojo.vo.Result;
import com.clearvision.mybatissample.entity.TbSchoolDeclare;
import com.clearvision.mybatissample.pojo.query.TestQuery;
import com.clearvision.mybatissample.service.ITbSchoolDeclareService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xutu
 * @since 2022-06-28
 */
@RestController
@RequestMapping("/tbSchoolDeclare")
public class TbSchoolDeclareController {

    @Resource
    private ITbSchoolDeclareService schoolDeclareService;


    @PostMapping("/pageList")
    public Result<PageInfoVO<List<TbSchoolDeclare>>> getPageList(@RequestBody @Validated TestQuery query) {
        PageInfoVO<List<TbSchoolDeclare>> pageInfoVO = schoolDeclareService.getPageList(query);
        return Result.succeed(pageInfoVO);
    }


    @GetMapping("/detail")
    public Result detail() {
        TbSchoolDeclare byId = schoolDeclareService.getById(406861124278030336L);
        return Result.succeed(byId);
    }


    @GetMapping("/edit")
    public Result edit(@RequestParam("param1") int param1) {
        TbSchoolDeclare TbSchoolDeclare = new TbSchoolDeclare();
//        boolean b = TbSchoolDeclareService.myUpdateById(TbSchoolDeclare);
        if (param1 == 1) {
            throw new CustomBusinessException(ErrorCodeEnum.OPERATION_FAIL);
        }
        return Result.succeed();
    }


    @GetMapping("/add")
    public Result add() {
        TbSchoolDeclare schoolDeclareDO = new TbSchoolDeclare();
        schoolDeclareDO = schoolAllSet();

        schoolDeclareDO.initDateForInsertNoAuth();
        boolean i = schoolDeclareService.save(schoolDeclareDO);
        if (!i){
            throw new CustomBusinessException(ErrorCodeEnum.OPERATION_FAIL);
        }
        return Result.succeed(i);
    }

    private TbSchoolDeclare schoolAllSet() {
        TbSchoolDeclare schoolDeclareDO = new TbSchoolDeclare();
        schoolDeclareDO.setSchoolName("");
        schoolDeclareDO.setBelongArea("");
        schoolDeclareDO.setPrefxInclude("");
        schoolDeclareDO.setOrgProperty(0);
        schoolDeclareDO.setSchoolType(0);
        schoolDeclareDO.setUrbanRuralAttributes(0);
        schoolDeclareDO.setSchoolLevel(0);
        schoolDeclareDO.setProvinceId(0);
        schoolDeclareDO.setProvince("");
        schoolDeclareDO.setCityId(0);
        schoolDeclareDO.setCity("");
        schoolDeclareDO.setRegionId(0);
        schoolDeclareDO.setRegion("");
        schoolDeclareDO.setSchoolCode("");
        schoolDeclareDO.setSchoolAttribute(0);
        schoolDeclareDO.setSchoolAddress("");
        schoolDeclareDO.setRefuseReason("");
        schoolDeclareDO.setSchoolDeclareState(0);
        schoolDeclareDO.setLng("");
        schoolDeclareDO.setLat("");
        schoolDeclareDO.setReporter(0L);
        schoolDeclareDO.setReportTime(LocalDateTime.now());
        schoolDeclareDO.setReporterPhone("");
        schoolDeclareDO.setRemark("");
        schoolDeclareDO.setContactPerson("");
        schoolDeclareDO.setContactPersonPhone("");
        schoolDeclareDO.setCreateTime(LocalDateTime.now());
        schoolDeclareDO.setUpdateTime(LocalDateTime.now());
        schoolDeclareDO.setStreet("");
        schoolDeclareDO.setCommunity("");
        schoolDeclareDO.setSocialCreditCode("");
        schoolDeclareDO.setIsMainCampus(0);
        schoolDeclareDO.setBranchCampusScCode("");
        schoolDeclareDO.setSchoolHoldType(0);
        schoolDeclareDO.setOrganizersType(0);
        schoolDeclareDO.setParentId(0L);

        return schoolDeclareDO;

    }


}
