package com.lemur.LemurLibrary.logging;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LemurLogger {
    public void log(String message, String env){
        if (env.equals("console")) {
            logToConsole(message);
        } else {
            try {
                logToFile(message);
            }catch (IOException ex) {
                logToConsole("File Logging failed, original message was:"+message);
            }
        }
    }
    private void logToConsole(String message){
        Logger consoleLogger = Logger.getLogger("ConsoleLogger");
        consoleLogger.info(message);
    }
    private void logToFile(String message) throws IOException {
        Logger fileLogger = Logger.getLogger("FileLogger");
        FileHandler fileHandler = new FileHandler("lemurLog.txt", true);
        fileLogger.setUseParentHandlers(false);
        fileLogger.addHandler(fileHandler);
        fileLogger.info(message);
        fileHandler.close();
    }
}
