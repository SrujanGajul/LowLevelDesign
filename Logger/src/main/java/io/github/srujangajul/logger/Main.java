package io.github.srujangajul.logger;

import io.github.srujangajul.logger.model.FileAppender;
import io.github.srujangajul.logger.model.Logger;

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getInstance();
        log.addAppender(new FileAppender("/file.log"));
        log.info("Info log message");
        log.debug("Debug log message");
        log.warn("Warn log message");
    }
}