package com.clearvision.mybatissample.controller;

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
    public String add() {
        TbSchoolDeclare TbSchoolDeclare = new TbSchoolDeclare();
        boolean save = schoolDeclareService.save(TbSchoolDeclare);
        return "";
    }







}
