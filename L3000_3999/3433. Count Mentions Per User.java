
import java.util.List;
import java.util.PriorityQueue;

abstract class Event {

    int timestamp;
    int order;
}

class OfflineEvent extends Event {

    public OfflineEvent(int timestamp, int index) {
        this.timestamp = timestamp;
        this.index = index;
        this.order = 1;
    }

    int index;

    @Override
    public String toString() {
        return "OfflineEvent{"
                + "index=" + index
                + ", timestamp=" + timestamp
                + ", order=" + order
                + '}';
    }
}

class MessageEvent extends Event {

    public MessageEvent(int timestamp, String mentionType) {
        this.timestamp = timestamp;
        this.mentionType = mentionType;
        this.order = 2;
    }

    String mentionType;

    @Override
    public String toString() {
        return "MessageEvent{"
                + "mentionType='" + mentionType + '\''
                + ", timestamp=" + timestamp
                + ", order=" + order
                + '}';
    }
}

class Solution {

    final String OFFLINE = "OFFLINE";

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int[] mentions = new int[numberOfUsers];
        int[] timeStampAvailable = new int[numberOfUsers];

        PriorityQueue<Event> eventQueue = new PriorityQueue<>(
                (Event a, Event b) -> {
                    if (a.timestamp != b.timestamp) {
                        return Integer.compare(a.timestamp, b.timestamp);
                    }

                    return Integer.compare(a.order, b.order);
                }
        );

        for (List<String> e : events) {
            String type = e.get(0);
            int timeStamp = Integer.parseInt(e.get(1));
            if (type.equals(OFFLINE)) {
                int id = Integer.parseInt(e.get(2));
                eventQueue.add(new OfflineEvent(timeStamp, id));
            } else {
                eventQueue.add(new MessageEvent(timeStamp, e.get(2)));
            }
        }

        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            int timeStamp = event.timestamp;
            for (int i = 0; i < numberOfUsers; i++) {
                if (timeStampAvailable[i] > 0 && timeStamp >= timeStampAvailable[i]) {
                    timeStampAvailable[i] = 0;
                }
            }

            if (event instanceof OfflineEvent offlineEvent) {
                timeStampAvailable[offlineEvent.index] = timeStamp + 60;
            } else if (event instanceof MessageEvent messageEvent) {
                String mentionType = messageEvent.mentionType;
                if ("HERE".equals(mentionType)) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (timeStampAvailable[i] == 0) {
                            mentions[i]++;
                        }
                    }
                } else if ("ALL".equals(mentionType)) {
                    for (int index = 0; index < numberOfUsers; index++) {
                        mentions[index]++;
                    }
                } else {
                    String[] mentionIds = mentionType.split(" ");
                    for (String id : mentionIds) {
                        int index = Integer.parseInt(id.substring(2));
                        mentions[index]++;
                    }
                }
            }
        }

        return mentions;
    }
}
