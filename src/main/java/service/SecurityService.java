package service;

public interface SecurityService {
    String getUsersLogin();
    void autoLogin(String login, String password);
}
