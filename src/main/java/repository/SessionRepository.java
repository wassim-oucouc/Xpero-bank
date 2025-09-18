package repository;

import model.Session;

public interface SessionRepository {


    public Session createSession(Session session);
    public void destroy();
}
