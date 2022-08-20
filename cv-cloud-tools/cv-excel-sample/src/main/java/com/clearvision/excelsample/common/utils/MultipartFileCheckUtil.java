package com.clearvision.excelsample.common.utils;

import com.clearvision.common.enums.ErrorCodeEnum;
import com.clearvision.common.enums.PunctuationEnum;
import com.clearvision.common.pojo.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author xutu
 * @date 2022/08/04
 */
public class MultipartFileCheckUtil {


    public static Result checkFile(MultipartFile file){
        if (null == file || file.isEmpty()) {
            return Result.fail(ErrorCodeEnum.REQUEST_PARAM_ERROR, "文件不能为空");
        }
        // 原始文件名
        String sourceName = file.getOriginalFilename();
        if (StringUtils.isBlank(sourceName)) {
            return Result.fail(ErrorCodeEnum.REQUEST_PARAM_ERROR, "文件不能为空");
        }
        String fileType = sourceName.substring(sourceName.lastIndexOf(PunctuationEnum.PERIOD.getCode()));
        if (StringUtils.isBlank(fileType)) {
            return Result.fail(ErrorCodeEnum.REQUEST_PARAM_ERROR, "文件不能为空");
        }
        return Result.succeed();
    }


}
