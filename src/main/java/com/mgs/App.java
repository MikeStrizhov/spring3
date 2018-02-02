package com.mgs;

import com.mgs.beans.Client;
import com.mgs.beans.Event;
import com.mgs.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Michael Strizhov on 01.02.2018.
 */
public class App {
    private Client client;
    private EventLogger eventLogger;

    public static void main(String[] args){
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        Event event = ctx.getBean("event", Event.class);
        app.logEvent(event, "Some event for user 1");
        event = ctx.getBean("event", Event.class);
        app.logEvent(event, "Some event for user 2");
        ctx.close();
    }

/*    public static void main(String[] args){
        App app = new App();
        app.client = new Client("1", "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");
    }*/

    public App(Client client, EventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
