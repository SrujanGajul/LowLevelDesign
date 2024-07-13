package io.github.srujangajul.logger.model;

public class DatabaseAppender implements LogAppender{
    //DataBaseConnection connection = new DatabaseConnection();
    @Override
    public void append(String message) {
        System.out.println("DatabaseAppender: "+ message);
    }
}
