package io.github.srujangajul.logger.model;

import java.util.LinkedList;

public class Logger {
    private LoggerConfig config;
    private static final Logger logger = new Logger(new LoggerConfig());

    private Logger(LoggerConfig config){
        this.config = config;
    }

    public static Logger getInstance(){
        return logger;
    }

    public synchronized void log(LogLevel level, String message){
        for(LogAppender appender: config.getAppenders()){
            if(config.getLevel().getLevel() <= level.getLevel()){
                appender.append(message);
            }
        }
    }

    public void error(String message){
        log(LogLevel.ERROR, message);
    }
    public void warn(String message){
        log(LogLevel.WARN, message);
    }
    public void info(String message){
        log(LogLevel.INFO, message);
    }
    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }
    public void trace(String message){
        log(LogLevel.TRACE, message);
    }

    public void addAppender(LogAppender appender){
        this.config.getAppenders().add(appender);
    }

}
