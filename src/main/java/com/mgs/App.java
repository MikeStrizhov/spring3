package com.mgs;

import com.mgs.beans.Client;
import com.mgs.beans.Event;
import com.mgs.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by Michael Strizhov on 01.02.2018.
 */
public class App {
    private Client client;
    private EventLogger defaultLogger;
    Map<EventType, EventLogger> loggers;

    public static void main(String[] args){
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        Event event = ctx.getBean("event", Event.class);
        app.logEvent(EventType.INFO, event, "Some event for user 1");
        event = ctx.getBean("event", Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for user 2");
        event = ctx.getBean("event", Event.class);
        app.logEvent(null, event, "Some event for user 3");
        ctx.close();
    }

/*    public static void main(String[] args){
        App app = new App();
        app.client = new Client("1", "John Smith");
        app.defaultLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");
    }*/

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType eventType, Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            defaultLogger.logEvent(event);
        } else {
            logger.logEvent(event);
        }
    }
}
