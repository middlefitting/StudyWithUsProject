package com.studywithus.config.aop.trace;

import java.util.UUID;

public class TraceId {
    private String id;
    private int level;

    public TraceId() { //디폴트 호출시 생성
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) { //id level 직접 넣는다.
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId() { //해당 객체의 id, level + 1 호출
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() { //해당 객체의 id, level -1 호출
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() { //level ==0 반환 boolean 해당 객체 레벨 따라 다름
        return level == 0;
    }

    public String getId() { //아이디 get
        return id;
    }

    public int getLevel() { //level get
        return level;
    }
}

