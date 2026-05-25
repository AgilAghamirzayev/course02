package lessoon23.designpatterns.creation.factory;

interface Notification {
    void send(String message);
}

enum NotificationType {
    EMAIL, SMS, PUSH
}

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SmsNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending push notification: " + message);
    }
}

class NotificationFactory {
    public static Notification createNotification(NotificationType type) {
        return switch (type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SmsNotification();
            case PUSH -> new PushNotification();
        };
    }
}