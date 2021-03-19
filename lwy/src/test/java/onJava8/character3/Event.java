package onJava8.character3;

//import java.time.Durationn;

import java.time.*;

//import static org.springframework.test.context.transaction.TestTransaction.start;

public abstract class Event {
    private Instant eventTime;
    protected final Duration delayTime;


    public Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }

    public void start() {
        eventTime = Instant.now().plus(delayTime);
    }
    public boolean ready(){
        return Instant.now().isAfter(eventTime);
    }

    public abstract void action();
}
