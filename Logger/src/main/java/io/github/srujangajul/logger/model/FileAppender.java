package io.github.srujangajul.logger.model;

import java.io.File;

public class FileAppender implements LogAppender{

    File file;

    public FileAppender(String path){
        this.file = new File(path);
    }

    @Override
    public void append(String message) {
        System.out.println("FileAppender: "+ message);
    }
}
