package repository.implement;

import model.Session;
import repository.SessionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InMemorySessionRepository implements SessionRepository{

    List<Session> sessionData = new ArrayList<>();

    public Session createSession(Session session)
    {
        sessionData.add(session);

        return session;
    }

    public void destroy()
    {
        sessionData = new ArrayList<>();
    }


}
