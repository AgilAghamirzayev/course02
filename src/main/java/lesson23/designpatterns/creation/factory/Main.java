package lesson23.designpatterns.creation.factory;

public class Main {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification(NotificationType.SMS);
        notification.send("Welcome to the system");
    }
}
