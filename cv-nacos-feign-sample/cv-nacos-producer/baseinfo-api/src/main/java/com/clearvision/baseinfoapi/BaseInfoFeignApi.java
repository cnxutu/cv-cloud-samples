package com.clearvision.baseinfoapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clearvision.common.pojo.vo.Result;
import com.clearvision.pojo.dto.SchoolDeclareDTO;
import com.clearvision.pojo.entity.TbSchoolDeclare;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述：用户接口
 *
 * @author xutu
 * @since 2022-07-05
 */
@FeignClient(name = "nacos-feign-provider")
public interface BaseInfoFeignApi {


    @RequestMapping(value = "/getSchoolDeclareById",method = RequestMethod.GET)
    public Result<SchoolDeclareDTO> getSchoolDeclareById(@RequestParam("id") Long id);


    @RequestMapping("/getUserName")
    String getUserName();


    @CollectionFormat(feign.CollectionFormat.CSV)
    @GetMapping(value = "/search/findByIdIn")
    String getByIds(@RequestParam("ids") Long[] ids);

//    @RequestMapping(value = "/getSchoolDeclareByWrapper",method = RequestMethod.POST)
//    Result<SchoolDeclareDTO> getSchoolDeclareByWrapper(QueryWrapper<TbSchoolDeclare> queryWrapper);
}
