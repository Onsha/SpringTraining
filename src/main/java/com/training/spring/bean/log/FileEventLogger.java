package com.training.spring.bean.log;

import com.training.spring.bean.Event;
import com.training.spring.bean.log.api.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by oleksandr
 */
public class FileEventLogger implements EventLogger {
    private String fileName;
    private File logFile;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init(){
        this.logFile = new File(fileName);
        if(!logFile.canWrite()){
            throw new RuntimeException("Can't access the file");
        }
    }

    public void log(Event event) {
        try {
            FileUtils.writeStringToFile(logFile, event.toString() + "\n", Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
