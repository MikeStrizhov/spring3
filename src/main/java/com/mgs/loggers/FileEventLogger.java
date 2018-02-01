package com.mgs.loggers;

import com.mgs.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Michael Strizhov on 01.02.2018.
 */
public class FileEventLogger implements EventLogger{
    private String fileName;
    private File file;

    public FileEventLogger(String fileName){
        this.fileName = fileName;
    }

    public void logEvent(Event event){
//        System.out.println(event.toString());
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        this.setFile(new File(fileName));
        file.canWrite();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
