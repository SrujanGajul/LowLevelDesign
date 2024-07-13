package io.github.srujangajul.logger.model;

import lombok.Getter;

@Getter
public enum LogLevel {
    ERROR(5),
    WARN(4),
    INFO(3),
    DEBUG(2),
    TRACE(1);

    final int level;

    LogLevel(int level){
        this.level = level;
    }

}
