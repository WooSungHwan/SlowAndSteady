package sas.study.blog.corejava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.Comparator.comparing;

public class Main {

    static int k = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        synchronizedMainExample();
        //appleExample();

    }

    private static void synchronizedMainExample() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.submit(() -> {
            long start = System.currentTimeMillis();
            synchronizedExample();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        });

        service.submit(() -> {
            long start = System.currentTimeMillis();
            nonSynchronizedExample();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        });
        service.shutdownNow();
    }

    private static void synchronizedExample() {
        for (int i = 0; i < 100000000; i++) {
            int newK = SynchronizedKeyowrdExample.getK() - 1;
            SynchronizedKeyowrdExample.setK(newK);
        }
    }

    private static void nonSynchronizedExample() {
        for (int i = 0; i < 100000000; i++) {
            int newK = NonSynchronizedKeywordExample.getK() - 1;
            NonSynchronizedKeywordExample.setK(newK);
        }
    }

    private static void appleExample() {
        List<Apple> apples = Arrays.asList(
                new Apple(1),
                new Apple(2),
                new Apple(3),
                new Apple(9),
                new Apple(5),
                new Apple(4)
        );

        // 기존 자바 7이하에서의 정렬
        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple apple1, Apple apple2) {
                return apple1.getWeight().compareTo(apple2.getWeight());
            }
        });

        // 정렬 확인
        System.out.println(apples);

        apples = Arrays.asList(
                new Apple(1),
                new Apple(2),
                new Apple(3),
                new Apple(9),
                new Apple(5),
                new Apple(4)
        );

        // 자바 8 이후의 정렬
        apples.sort(comparing(Apple::getWeight));

        // 정렬확인
        System.out.println(apples);
    }

    @ToString
    @Getter
    @AllArgsConstructor
    static
    class Apple {
        Integer weight;
    }

}
