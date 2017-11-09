package com.boss.brainer.domain.mongo;

import org.springframework.util.StringUtils;

public enum GameMode {

    SIMPLE,
    BLITZ;

    public static GameMode getValue(String mode){
        if(StringUtils.isEmpty(mode))
            return null;

        return GameMode.valueOf(mode.toUpperCase());
    }
}
