import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LoggerRateLimiter {
    class Logger {
        private Map<String, Integer> logToTimestamp;

        /** Initialize your data structure here. */
        public Logger() {
            logToTimestamp = new HashMap<>();
        }


        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!logToTimestamp.containsKey(message) || timestamp - logToTimestamp.get(message) >= 10) {
                logToTimestamp.put(message, timestamp);
                return true;
            }
            return false;
        }
    }

    class Logger2 {

        class Log {
            int timestamp;
            String message;
            Log(int timestamp, String message) {
                this.timestamp = timestamp;
                this.message = message;
            }
        }

        private Queue<Log> queue;
        private Set<String> set;

        /** Initialize your data structure here. */
        public Logger2() {
            queue = new LinkedList<>();
            set = new HashSet<>();
        }


        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            while(!queue.isEmpty() && timestamp - queue.peek().timestamp >= 10) {
                Log log = queue.poll();
                set.remove(log.message);
            }

            if (set.contains(message)) {
                return false;
            }
            set.add(message);
            queue.offer(new Log(timestamp, message));
            return true;
        }
    }

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
}
