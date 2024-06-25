package com.cv.excelsample.common.utils;

import cn.hutool.core.util.StrUtil;
import com.cv.common.enums.ErrorCodeEnum;
import com.cv.common.exception.CustomBusinessException;
import com.cv.excelsample.common.enums.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 获取Excel表头
 *
 * @author xutu
 * @date 2022/08/04 10:34
 */
@Slf4j
public class ReadExcelHeaderUtil {

    private static final String[] STUDNET_INFO_IMPORT_SEGMENT = {"学生姓名", "出生日期", "证件号", "民族", "家庭住址", "家长姓名", "家长手机"};

    public static boolean existExcelHeader(MultipartFile file, ExcelTypeEnum excelTypeEnum, Integer headerRowNumber) {
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            log.error("----------------解析Excel异常：", e);

            throw new CustomBusinessException(ErrorCodeEnum.OTHER_ERROR.getCode(), "读取Excel失败，请稍后再试");
        }
        if (!validateExcel(file.getOriginalFilename())) {
            throw new CustomBusinessException(ErrorCodeEnum.REQUEST_PARAM_ERROR.getCode(), "文件不是Excel格式");
        }
        List<String> headerListByReadExcel;
        List<String> mustHeaderList = new ArrayList<>();
        try {
            if (headerRowNumber > 1) {
                List<Map<Integer, String>> excelHeader = EasyExcelUtil.getExcelHeader(inputStream, headerRowNumber);
                headerListByReadExcel = getHeaderListByReadExcel(excelHeader.get(headerRowNumber - 1));
                switch (excelTypeEnum) {
                    case STUDNET_INFO_IMPORT:
                        mustHeaderList = new ArrayList<>(Arrays.asList(STUDNET_INFO_IMPORT_SEGMENT));
                        break;
//                    case SHOULD_SCREEN_STUDENT_COUNT_IMPORT:
//                        mustHeaderList = new ArrayList<>(Arrays.asList(SHOULD_SCREEN_STUDENT_COUNT_SEGMENT));
//                        break;
                    default:
                        break;
                }
            } else {
                Map<Integer, String> excelHeader = EasyExcelUtil.getExcelHeader(inputStream);
                headerListByReadExcel = getHeaderListByReadExcel(excelHeader);
                switch (excelTypeEnum) {
                    case STUDNET_INFO_IMPORT:
                        mustHeaderList = new ArrayList<>(Arrays.asList(STUDNET_INFO_IMPORT_SEGMENT));
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            throw new CustomBusinessException(ErrorCodeEnum.REQUEST_PARAM_ERROR.getCode(), "表头检索失败，请下载相应Excel模板进行填充数据或复制Excel模板的表头至当前文件中");
        }
        if (CollectionUtils.isEmpty(headerListByReadExcel)) {
            throw new CustomBusinessException(ErrorCodeEnum.REQUEST_PARAM_ERROR.getCode(), "表头" + mustHeaderList.toString() + "缺失");
        }
        mustHeaderList.removeIf(headerListByReadExcel::contains);
        if (!CollectionUtils.isEmpty(mustHeaderList)) {
            throw new CustomBusinessException(ErrorCodeEnum.REQUEST_PARAM_ERROR.getCode(), "表头" + mustHeaderList.toString() + "缺失");
        }
        return true;
    }

    private static List<String> getHeaderListByReadExcel(Map<Integer, String> excelHeader) {
        List<String> headerListByReadExcel = new ArrayList<>();
        final int maxHeaderCount = 20;
        for (Map.Entry<Integer, String> entry : excelHeader.entrySet()) {
            Integer key = entry.getKey();
            if (key > maxHeaderCount) {
                continue;
            }
            String value = entry.getValue();
            headerListByReadExcel.add(value);
        }
        return headerListByReadExcel;
    }

    public static boolean validateExcel(String filePath) {
        return !StrUtil.isBlank(filePath) && (isExcel3(filePath) || isExcel7(filePath));
    }

    private static boolean isExcel3(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    private static boolean isExcel7(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }


}
