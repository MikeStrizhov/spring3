package com.mgs.loggers;

import com.mgs.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(String fileName, int cacheSize){
        super(fileName);
        this.cacheSize = cacheSize;
//        this.setFileName(fileName);
    }

    @Override
    public void logEvent(Event event){
        cache.add(event);
        if (cache.size() >= cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void destroy(){
        if (!cache.isEmpty()){
            writeEventsFromCache();
        }
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void writeEventsFromCache(){
        for (Event event: cache){
            writeEvent(event);
        }
    }

    private void writeEvent(Event event){
        try {
            FileUtils.writeStringToFile(getFile(), event.toString()+"\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
