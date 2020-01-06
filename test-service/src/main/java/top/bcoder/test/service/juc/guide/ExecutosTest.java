package top.bcoder.test.service.juc.guide;

import org.junit.Test;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zln
 * @date 2019/12/27
 */
public class ExecutosTest {

    @Test
    public void testThreadPoolExecutorSubmit() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy());

        Future<Integer> submit = executor.submit(() -> {
            System.out.println("我是子线程，我需要等待5s");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (true) {
                throw new RuntimeException("aaa");
            }
            System.out.println("我是子线程，我执行完了");
            return 10;
        });

        System.out.println("我是主线程，当前时间：" + LocalDateTime.now());
        Integer integer = null;
        try {
            integer = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("子线程出错，错误信息为：" + e.getMessage());
        }
        System.out.println("我是主线程，子线程执行完了，执行结果：" + integer + "当前时间：" + LocalDateTime.now());

    }


    @Test
    public void testThreadPoolExecutorExecutor() throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy());

        executor.execute(() -> {
            System.out.println("我是子线程，我需要等待5s");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (true) {
                throw new RuntimeException("aaa");
            }
            System.out.println("我是子线程，我执行完了");
        });

        TimeUnit.SECONDS.sleep(10);
        System.out.println("主线程执行完毕");

    }


    @Test
    public void testThreadPoolExecutorKeepAliveTime() throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                15,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy());


        for (int i = 1; i < 16; i++) {
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "执行中");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

//        while (true) {
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println(executor.getPoolSize());
//        }

        TimeUnit.SECONDS.sleep(10);

    }
    @Test
    public void testThreadPoolExecutorRejected() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                15,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                //new ThreadPoolExecutor.AbortPolicy()); //throw RejectedExecutionException
                //new ThreadPoolExecutor.CallerRunsPolicy());//放在主线程重试
                //new ThreadPoolExecutor.DiscardPolicy());//超出范围全部丢弃
                new ThreadPoolExecutor.DiscardOldestPolicy());//弹出队列最老的值

        for (int i = 1; i < 50; i++) {
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "执行中");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(20);
    }

}
