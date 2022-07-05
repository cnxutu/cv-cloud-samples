package com.clearvision.nacosfeignsample.consumer.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clearvision.baseinfoapi.BaseInfoFeignApi;
import com.clearvision.common.enums.DeleteEnum;
import com.clearvision.common.pojo.vo.Result;
import com.clearvision.nacosfeignsample.consumer.pojo.vo.SchoolDeclareVO;
import com.clearvision.pojo.dto.SchoolDeclareDTO;
import com.clearvision.pojo.entity.TbSchoolDeclare;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author xutu
 * @since 2022-07-05
 */
@RestController
public class TestController {

    @Resource
    private BaseInfoFeignApi baseInfoFeignApi;


    /**
     * 根据id查找
     *
     * @param declaredSchoolId
     * @return
     */
    @RequestMapping(value = "/getDeclaredSchoolById", method = RequestMethod.GET)
    public Result<SchoolDeclareVO> getDeclaredSchoolById(@RequestParam("id") Long declaredSchoolId) {
        Result<SchoolDeclareDTO> declareSchoolDTO = baseInfoFeignApi.getSchoolDeclareById(declaredSchoolId);
        SchoolDeclareVO schoolDeclareVO = new SchoolDeclareVO();
        BeanUtil.copyProperties(declareSchoolDTO.getData(), schoolDeclareVO);
        return Result.succeed(schoolDeclareVO);
    }




    @RequestMapping("/test")
    public String test() {
        String userName = baseInfoFeignApi.getUserName();
        return userName;
    }

}
