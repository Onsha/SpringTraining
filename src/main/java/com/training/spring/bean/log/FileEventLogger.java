package com.training.spring.bean.log;

import com.training.spring.bean.Event;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by oleksandr
 */
public class FileEventLogger extends AbstractLogger {
    private String fileName;
    private File logFile;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        this.logFile = new File(fileName);
        try {
            logFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!logFile.canWrite()) {
            throw new RuntimeException("Can't access the file");
        }
    }

    public void log(Event event) {
        try {
            String logString = event.getFormattedDate() + LOG_SEPARATOR +
                    getPlace() + event + StringUtils.LF;
            FileUtils.writeStringToFile(logFile, logString, Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
