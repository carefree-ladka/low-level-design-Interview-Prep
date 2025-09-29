package bookslibrary.service;

public interface INotificationService {
    void notifyUser(String userEmail, String subject, String message);
}

