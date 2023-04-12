abstract class Notifier {
  void send(String message);
}

class DefaultNotifier extends Notifier {
  @override
  void send(String message) {
    print('Sending message to Server: $message');
  }
}

abstract class NotifierSupportDecorator extends Notifier {
  NotifierSupportDecorator(this.wrappee);

  final Notifier wrappee;

  @override
  void send(String message) {
    wrappee.send(message);
  }
}

class SMSNotifier extends NotifierSupportDecorator {
  SMSNotifier(super.wrappee);

  @override
  void send(String message) {
    super.send(message);
    sendSMS(message);
  }

  void sendSMS(String message) {
    print("Ting Ting, SMS send message: \"$message\"");
  }
}

class FacebookNotifier extends NotifierSupportDecorator {
  FacebookNotifier(super.wrappee);

  @override
  void send(String message) {
    super.send(message);
    sendMessenger(message);
  }

  void sendMessenger(String message) {
    print("Kock, Messenger send message: \"$message\"");
  }
}

class SlackNotifier extends NotifierSupportDecorator {
  SlackNotifier(super.wrappee);

  @override
  void send(String message) {
    super.send(message);
    sendSlack(message);
  }

  void sendSlack(String message) {
    print("Bum, Slack send message: \"$message\"");
  }
}

void main() {
  Notifier notifier = DefaultNotifier();
  notifier = FacebookNotifier(notifier);
  notifier = SMSNotifier(notifier);
  notifier = SlackNotifier(notifier);

  notifier.send('Go to sleep before 00:00');
}
