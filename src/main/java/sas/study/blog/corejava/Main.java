package sas.study.blog.corejava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {

        appleExample();

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
