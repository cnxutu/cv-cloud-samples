package com.cv.log.sample.service;

import com.cv.log.sample.pojo.dto.OperationLogDTO;

/**
 * @author: xutu
 * @since: 2025/4/11 10:44
 */
public interface LogPersistService {
    void save(OperationLogDTO log);
}
