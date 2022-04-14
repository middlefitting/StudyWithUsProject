package com.studywithus.config.aop.trace.logtrace;

import com.studywithus.config.aop.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
