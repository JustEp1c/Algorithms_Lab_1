package com.stack;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    // Исполняющий класс

    public static long N_op = 0;

    public static void main(String[] args) {

        MyStack originalStack = new MyStack();

        for (int i = 0; i < 500; i++) {

            originalStack.set(ThreadLocalRandom.current().nextInt(1000) + 1);
        }

        Instant start = Instant.now();
        System.out.println("Сортировка началась...");
        System.out.println(originalStack.sort());
        System.out.println("Сортировка успешно завершилась.");
        Instant finish = Instant.now();
        float elapsed = Duration.between(start, finish).toNanos();
        System.out.println("Прошло времени, мс: " + elapsed / 1000000);
        System.out.println("Прошло времени, с: " + elapsed / 1000000000);
        System.out.println("Кол-во операций: " + N_op);
        N_op = 0;

    }
}
