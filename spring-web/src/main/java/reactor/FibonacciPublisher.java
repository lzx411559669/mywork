package reactor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

    public class FibonacciPublisher implements Publisher<Integer> {
        @Override
        public void subscribe(Subscriber<? super Integer> subscriber) {

            subscriber.onComplete();
        }

        public void close() {
            System.out.println("close");
        }
    }

