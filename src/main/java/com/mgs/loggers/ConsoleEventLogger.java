package com.mgs.loggers;

import com.mgs.beans.Event;

/**
 * Created by Michael Strizhov on 01.02.2018.
 */
public class ConsoleEventLogger implements EventLogger{

    public void logEvent(Event event){
        System.out.println(event.toString());
    }
}
