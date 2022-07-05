package com.clearvision.nacosfeignsample.consumer.client;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clearvision.baseinfoapi.BaseInfoFeignApi;
import com.clearvision.common.pojo.vo.Result;
import com.clearvision.nacosfeignsample.consumer.pojo.entity.TbSchoolDeclare;
import com.clearvision.nacosfeignsample.consumer.service.ITbSchoolDeclareService;
import com.clearvision.pojo.dto.SchoolDeclareDTO;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 描述：UserFeignApiClient
 *
 * @author ay
 * @since 2020-07-24
 */
@RestController
public class BaseInfoFeignApiClient implements BaseInfoFeignApi {


    @Resource
    private ITbSchoolDeclareService schoolDeclareService;


    @Override
    @RequestMapping(value = "/getSchoolDeclareById",method = RequestMethod.GET)
    public Result<SchoolDeclareDTO> getSchoolDeclareById(@RequestParam("id") Long id) {
//        BaseMapper<TbSchoolDeclare> baseMapper = schoolDeclareService.getBaseMapper();
        QueryWrapper<TbSchoolDeclare> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        TbSchoolDeclare schoolDeclare = schoolDeclareService.getOne(queryWrapper);
        SchoolDeclareDTO schoolDeclareDTO = new SchoolDeclareDTO();
        BeanUtil.copyProperties(schoolDeclare,schoolDeclareDTO);
        return Result.succeed(schoolDeclareDTO);
    }







    @Override
    @RequestMapping("/getUserName")
    public String getUserName() {
        return "hello, ay";
    }



    @Override
    @GetMapping(path = "/search/findByIdIn")
    @CollectionFormat(feign.CollectionFormat.CSV)
    public String getByIds(@RequestParam("ids") Long[] ids) {
        return "success";
    }







}
