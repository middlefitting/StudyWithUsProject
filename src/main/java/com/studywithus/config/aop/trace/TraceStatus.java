package com.studywithus.config.aop.trace;

public class TraceStatus {
    private TraceId traceId; //아이디
    private Long startTimeMs; //시작시간
    private String message; //메시지

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) { //넣어서 생성한다
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }

    public TraceId getTraceId() {
        return traceId;
    }
}