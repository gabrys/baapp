package pl.beeraddict.baapp.authenticator;

public interface LogoutService {
    void logout(Runnable onSuccess);
}
