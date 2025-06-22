public class NotificationTest {
    public static void main(String[] args) {
        // Base notifier
        Notifier notifier = new EmailNotifier();

        // Add SMS
        notifier = new SMSNotifierDecorator(notifier);

        // Add Slack
        notifier = new SlackNotifierDecorator(notifier);

        // Send all notifications
        notifier.send();
    }
}
