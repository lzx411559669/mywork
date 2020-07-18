package reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReactorTest {
    public Flux<String> ppendstringReactive() {
        Flux<String> stringFlux = Flux.just("Quick ", "brown ", "fox ", "jumped ", "over ", "the ", "wall.");
        return stringFlux;
    }
    int sum =0;
    public void  getAverage(int var){
        sum += var;
    }

    @Test
    public void create() {
     //   ppendstringReactive().subscribe(System.out::println);

        //just方法
        String[] arr = new String[]{"hello", "world"};
        Flux<String> flux1 = Flux.just(arr);
       // flux1.subscribe(System.out::println);

        Mono<String> mono = Mono.just("hi world");
     //   mono.subscribe(System.out::println);

        //fromArray方法
        List<String> list = Arrays.asList("1", "2","3","4");
        Flux<String> flux2 = Flux.fromIterable(list);


       // flux2.subscribe(System.out::println);
        Flux<Integer> flux7 = Flux.range(1,5);
        flux7.subscribe(var-> getAverage(var));

        System.out.println(sum);
        //fromIterable方法
        List<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Orange");
        fruitList.add("Grape");
        fruitList.add("Banana");
        fruitList.add("Strawberry");
        Flux<String> flux3 = Flux.fromIterable(fruitList);

        //fromStream方法
        Stream<String> stream = Stream.of("hi", "hello");
        Flux<String> flux4 = Flux.fromStream(stream);

        //range方法
        Flux<Integer> range = Flux.range(0, 5);

        //interval方法, take方法限制个数为5个
        Flux<Long> longFlux = Flux.interval(Duration.ofSeconds(1)).take(5);
        LocalDate now = LocalDate.now();
        //longFlux.subscribe(t -> System.out.println("语句在前，但是有等待"+t));
       // Flux.interval(Duration.ofNanos(1)).elementAt(3).subscribe(t -> System.out.println("语句在前，但是有等待"+t));

    }

}
