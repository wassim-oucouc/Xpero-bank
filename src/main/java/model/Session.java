package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Session{


    private static UUID session_Id;
    private static UUID user_id;
    private static String email;
    private static LocalDateTime loginTime;
    private static LocalDateTime lastActivityTime;
    private static boolean isLoggedIn;

    public Session(UUID session_Id, UUID user_id, String email, LocalDateTime loginTime, LocalDateTime lastActivityTime, boolean isLoggedIn) {
        Session.session_Id = session_Id;
        Session.user_id = user_id;
        Session.email = email;
        Session.loginTime = loginTime;
        Session.lastActivityTime = lastActivityTime;
        Session.isLoggedIn = isLoggedIn;
    }

    public UUID getSession_Id(){
        return session_Id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setSession_Id(UUID session_Id) {
        Session.session_Id = session_Id;
    }

    public void setUser_id(UUID user_id) {
        Session.user_id = user_id;
    }

    public void setEmail(String email) {
        Session.email = email;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        Session.loginTime = loginTime;
    }

    public void setLastActivityTime(LocalDateTime lastActivityTime) {
        Session.lastActivityTime = lastActivityTime;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public LocalDateTime getLastActivityTime() {
        return lastActivityTime;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
