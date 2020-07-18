package reactor;

import java.util.Arrays;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;



public class FlowDemo
{
    public static void main(String[] args)
    {
        // Create a publisher.

        FibonacciPublisher publisher = new FibonacciPublisher();

        // Create a subscriber and register it with the publisher.

        MySubscriber<Integer> subscriber = new MySubscriber<>();
        publisher.subscribe(subscriber);

        // Publish several data items and then close the publisher.

        System.out.println("Publishing data items...");

        publisher.close();

        try
        {
            synchronized("A")
            {
                "A".wait();
            }
        }
        catch (InterruptedException ie)
        {
        }
    }
}

class MySubscriber<T> implements Subscriber<T>
{
    private Subscription subscription;


    public void onSubscribe(Subscription subscription)
    {
        this.subscription = subscription;
        subscription.request(2);
    }

    @Override
    public void onNext(T item)
    {
        System.out.println("Received: " + item);
        subscription.request(2);
    }

    @Override
    public void onError(Throwable t)
    {
        t.printStackTrace();
        synchronized("A")
        {
            "A".notifyAll();
        }
    }

    @Override
    public void onComplete()
    {
        System.out.println("Done");
        synchronized("A")
        {
            "A".notifyAll();
        }
    }
}