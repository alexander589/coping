package gfghf;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> task = new MyCallable();
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();

        String result = future.get();
        System.out.println(result);


        ExecutorService executor = Executors.newFixedThreadPool(2);

        MyCallable task1 = new MyCallable();
        Future<String> future1 = executor.submit(task1);

        MyCallable task2 = new MyCallable();
        Future<String> future2 = executor.submit(task2);

        MyCallable task3 = new MyCallable();
        Future<String> future3 = executor.submit(task3);

        MyCallable task4 = new MyCallable();
        Future<String> future4 = executor.submit(task4);

        Thread.sleep(5000);

        String string = future1.get();
        String string2 = future2.get();
        String string3 = future3.get();
        String string4 = future4.get();

        System.out.println(string);
        System.out.println(string2);
        System.out.println(string3);
        System.out.println(string4);

    }


    public static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "Hello Class!";
        }
    }
}
