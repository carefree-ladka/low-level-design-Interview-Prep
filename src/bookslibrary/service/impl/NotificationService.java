package bookslibrary.service.impl;

import bookslibrary.service.INotificationService;

public class NotificationService implements INotificationService {

    @Override
    public void notifyUser(String userEmail, String subject, String message) {
        System.out.println("Notify " + userEmail + " | " + subject + ": " + message);
    }
}