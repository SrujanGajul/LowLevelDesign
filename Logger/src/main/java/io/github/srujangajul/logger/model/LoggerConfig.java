package io.github.srujangajul.logger.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class LoggerConfig {
    private LogLevel level;
    private List<LogAppender> appenders = new LinkedList<>();

    public LoggerConfig(){
        level = LogLevel.INFO;
        appenders.add(new ConsoleAppender());
    }

    public LoggerConfig(LogLevel level, LogAppender appender){
        this.level  = level;
        this.appenders.add(appender);
    }
}
