CREATE TABLE operation_log (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    username VARCHAR(100),
    operation VARCHAR(255),
    method VARCHAR(255),
    uri VARCHAR(255),
    http_method VARCHAR(10),
    ip VARCHAR(45),
    request_params TEXT,
    response_result TEXT,
    success BOOLEAN,
    operate_time DATETIME,
    execution_time BIGINT,
    user_agent TEXT,
    trace_id VARCHAR(100)
);