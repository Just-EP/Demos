package pers.demos.websocket.handler;

import org.springframework.stereotype.Service;

import javax.websocket.Session;

/**
 * @author JustEP
 * @version 1.0
 * @date 2021/7/18 23:54
 */
public class SessionSaver {

    private static SessionSaver sessionSaver;


    private Session session;

    private SessionSaver(Session session) {
        this.session = session;
    }

    public static SessionSaver getInstance(Session session) {
        if (sessionSaver == null) {
            sessionSaver = new SessionSaver(session);
        }
        return sessionSaver;
    }

    public void saveSession(Session session){
        this.session = session;
    }
    public Session getSession(){
        return this.session;
    }

}
