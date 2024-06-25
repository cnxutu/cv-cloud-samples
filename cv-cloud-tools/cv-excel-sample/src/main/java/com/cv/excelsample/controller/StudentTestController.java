package com.cv.excelsample.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cv.common.enums.DeleteEnum;
import com.cv.common.pojo.vo.Result;
import com.cv.excelsample.common.enums.ExcelTypeEnum;
import com.cv.excelsample.common.utils.EasyExcelUtil;
import com.cv.excelsample.common.utils.MultipartFileCheckUtil;
import com.cv.excelsample.common.utils.ReadExcelHeaderUtil;
import com.cv.excelsample.pojo.entity.StudentBaseDO;
import com.cv.excelsample.pojo.vo.StudentModelVO;
import com.cv.excelsample.pojo.vo.StudentWriteVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * excel操作 案例
 * </p>
 *
 * @author xutu
 * @since 2022-08-04
 */
@RestController
@RequestMapping("/studentTest")
public class StudentTestController {


//    @Resource
//    private IStudentBaseService studentBaseService;
//
//    @Resource
//    private IStudentAttendService studentAttendService;


    /**
     * @param file {@link }
     * @return {@link Result}
     * @author xutu
     * @date 2022-08-04 10:49:13
     * @description excel数据导入
     * @menu 学生信息
     **/
    @RequestMapping(value = "/importExcelStudentData", method = RequestMethod.POST)
    public Result<List<StudentModelVO>> importExcelStudentData(@RequestParam("file") MultipartFile file, @RequestParam("importFileType") Integer importFileType) {
        Result checkResult = MultipartFileCheckUtil.checkFile(file);
        if (checkResult.isSuccess()) {
            ReadExcelHeaderUtil.existExcelHeader(file, ExcelTypeEnum.STUDNET_INFO_IMPORT, 1);
        } else {
            return checkResult;
        }
        //数据读取
        List<StudentModelVO> dataList = EasyExcelUtil.readExcelWithModel(file, StudentModelVO.class, 1);
        return Result.succeed(dataList);
    }


    /**
     * @param id {@link }
     * @return {@link Result}
     * @author xutu
     * @date 2022-08-04 10:49:13
     * @description excel数据导出
     * @menu 学生信息
     **/
    @RequestMapping(value = "/exportExcelStudentData", method = RequestMethod.GET)
    public Result exportExcelStudentData(HttpServletResponse response, @RequestParam("id") Long id) {
        String sysName = System.getProperty("os.name").toLowerCase();
        String path = "";
        if (sysName.contains("mac")) {
            path = "/Users/xutu/Documents/clear_vision/file_test/";
        } else if (sysName.contains("windows")) {
            path = "E://files";
        } else {
            path = "/var";
        }
        String fileName = path + "demo-" + System.currentTimeMillis() + ".xlsx";
//        try {
//            response.setContentType("application/vnd.ms-excel");
//            response.setCharacterEncoding("utf-8");
//            fileName = URLDecoder.decode("", "UTF-8");
//            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
//            List<StudentBaseDO> list = studentBaseService.list(Wrappers.<StudentBaseDO>lambdaQuery()
//                    .eq(StudentBaseDO::getIsDeleted, DeleteEnum.NORMAL.getCode())
//            );
//        List<StudentWriteVO> studentWriteVOS = BeanUtil.copyToList(list, StudentWriteVO.class);
//            EasyExcel.write(response.getOutputStream(), StudentWriteVO.class).sheet(fileName).doWrite(studentWriteVOS);
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // orm 获取数据
        List list = new ArrayList<>();
//        List<StudentBaseDO> list = studentBaseService.list(Wrappers.<StudentBaseDO>lambdaQuery()
//                .eq(StudentBaseDO::getIsDeleted, DeleteEnum.NORMAL.getCode())
//        );
        List<StudentWriteVO> studentWriteVOS = BeanUtil.copyToList(list, StudentWriteVO.class);
        EasyExcel.write(fileName, StudentWriteVO.class).sheet("模板").doWrite(studentWriteVOS);
        return Result.succeed();
    }

}
