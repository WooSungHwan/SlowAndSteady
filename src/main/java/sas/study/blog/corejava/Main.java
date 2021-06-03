package sas.study.blog.corejava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * 모던 자바 인 액션을 읽으면서 예제 짜보는 클래스
 */
public class Main {

    static int k = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
//        synchronizedMainExample();
//        appleExample();
            appleLambdaPredicateExample();
    }

    /**
     * Lambda 표현식을 통해 Predicate를 던져서 필터링 해보기
     */
    private static void appleLambdaPredicateExample() {
        List<Apple> apples = Apple.toList(100, 150, 60, 20, 130, 140);

        // 원본에는 영향 x
        Predicate<Apple> productPredicate = apple -> apple.getWeight() >= 100;
        List<Apple> product = filter(apples, productPredicate);// 사과무게 100 이상

        Predicate<Apple> trashPredicate = apple -> apple.getWeight() < 100;
        List<Apple> trash = filter(apples, trashPredicate);// 사과무게 100 미만

        System.out.println(product.toString());
        System.out.println(trash.toString());
    }

    private static List<Apple> filter(List<Apple> apples, Predicate<Apple> applePredicate) {
        return apples.stream().filter(apple -> applePredicate.test(apple)).collect(Collectors.toList());
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
        List<Apple> apples = Apple.toList(1,5,7,2,3,6);

        // 기존 자바 7이하에서의 정렬
        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple apple1, Apple apple2) {
                return apple1.getWeight().compareTo(apple2.getWeight());
            }
        });

        // 정렬 확인
        System.out.println(apples);

        apples = Apple.toList(1,5,7,2,3,6);

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

        public static List<Apple> toList(Integer... weight) {
            List<Apple> apples = new ArrayList<>(weight.length);
            for (Integer i : weight) {
                apples.add(new Apple(i));
            }
            return apples;
        }

    }

}
