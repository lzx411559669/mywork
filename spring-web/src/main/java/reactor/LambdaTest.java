package reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class LambdaTest {
    public static void main(String[] args) {
         List<String> lists = new ArrayList<>();

        lists.add("hello");
        lists.add("world");
        lists.add("刘正星");
        //第一种
        lists.forEach(s->System.out.println(s));
        IntBinaryOperator add = (int a, int b) -> {
            return a + b;
        };

       // 第二种
        lists.forEach(System.out::println);

    }



}
