package top.bcoder.test.service.juc.course;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

public class FutureTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        System.out.println("执行开始:" + LocalDateTime.now());
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        FutureTask<Integer> s1 = new FutureTask<>(() -> {
            System.out.println("电商s1询价");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("电商s1询价完毕");
            return new Random().nextInt(100);
        });


        FutureTask<Integer> s2 = new FutureTask<>(() -> {
            System.out.println("电商s2询价");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("电商s2询价完毕");
            return new Random().nextInt(100);
        });

        FutureTask<Integer> s3 = new FutureTask<>(() -> {
            System.out.println("电商s3询价");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("电商s3询价完毕");
            return new Random().nextInt(100);
        });


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4,
                10,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                (r) -> {
                    System.out.println("线程池创建一个新线程");
                    Thread thread = new Thread(r);
                    thread.setName("CUSTOM_NAME_PREFIX");
                    return thread;
                }, new ThreadPoolExecutor.CallerRunsPolicy());

        poolExecutor.execute(s1);
        poolExecutor.execute(()-> {
            try {
                blockingQueue.put(s1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        poolExecutor.execute(s2);
        poolExecutor.execute(()-> {
            try {
                blockingQueue.put(s2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        poolExecutor.execute(s3);
        poolExecutor.execute(()-> {
            try {
                blockingQueue.put(s3.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });


        for (int i = 0; i < 3; i++) {
            Integer take = blockingQueue.take();
            poolExecutor.execute(() -> System.out.println("保存询价信息：" + take));
        }

        System.out.println("执行结束:" + LocalDateTime.now());

    }

    @Test
    public void test2() {

    }
}
