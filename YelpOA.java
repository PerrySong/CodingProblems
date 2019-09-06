import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YelpOA {

    public static class Event {

        int business;
        String type;
        int count;
        public Event(String _type, int _count, int _bussiness) {
            business = _bussiness;
            type = _type;
            count = _count;
        }
    }

    class Frequency {
        int sum;
        int count;
        public Frequency(int _sum, int _count) {
            sum = _sum;
            count = _count;
        }

        public double average() {
            return (double)sum / (double)count;
        }
    }

    public List<Integer> activeBusiness(Event[] events) {
        if (events == null || events.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<Event>> bToEvents = new HashMap<>();
        Map<String, Frequency> typeToFreq = new HashMap<>();
        for (Event event : events) {
            int business = event.business;
            List<Event> eventList = bToEvents.getOrDefault(business, new ArrayList<>());
            eventList.add(event);
            bToEvents.put(business, eventList);

            Frequency frequency = typeToFreq.getOrDefault(event.type, new Frequency(0, 0));
            frequency.sum = frequency.sum + event.count;
            frequency.count = frequency.count + 1;
            typeToFreq.put(event.type, frequency);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Event>> entry : bToEvents.entrySet()) {
            int active = 0;
            for (Event event : entry.getValue()) {
                Frequency frequency = typeToFreq.get(event.type);
                if (frequency == null) continue;
                if (event.count >=  frequency.average()) {
                    active++;
                }
                if (active == 2) {
                    res.add(entry.getKey());
                    break;
                }
            }
        }
        return res;
    }





    public static void main(String[] args) {
        YelpOA a = new YelpOA();

        Event e1 = new Event("ads", 7, 3);
        Event e2 = new Event("ads", 8, 2);
        Event e3 = new Event("ads", 5, 1);
        Event e4 = new Event("page_views", 11, 2);
        Event e5 = new Event("page_views", 12, 3);
        Event e6 = new Event("photo_views", 10, 3);
        Event e7 = new Event("reviews", 7, 2);

        Event[] events = new Event[7];
        events[0] = e1;
        events[1] = e2;
        events[2] = e3;
        events[3] = e4;
        events[4] = e5;
        events[5] = e6;
        events[6] = e7;
        System.out.println(a.activeBusiness(events));

    }
}
