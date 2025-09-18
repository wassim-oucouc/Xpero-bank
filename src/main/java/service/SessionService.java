package service;

import model.Session;
import repository.SessionRepository;

public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository)
    {
        this.sessionRepository = sessionRepository;
    }


    public Session createSession(Session session)
    {
        return this.sessionRepository.createSession(session);
    }

    public void destroySession()
    {
        this.sessionRepository.destroy();
    }
}
