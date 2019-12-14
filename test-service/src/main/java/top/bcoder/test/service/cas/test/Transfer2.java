package top.bcoder.test.service.cas.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 加锁转账实现
 *
 * @author zln
 * @date 2019/12/12
 */
public class Transfer2 implements Runnable {

    private Integer balance;
    private Lock lock = new ReentrantLock();
    private CountDownLatch count;

    public Transfer2(Integer balance, CountDownLatch count) {
        this.balance = balance;
        this.count = count;
    }

    public static void main(String[] args) throws InterruptedException {
        //初始账户0源
        int balance = 0;

        //转账10000次，每次1元
        CountDownLatch count = new CountDownLatch(10000);
        Transfer2 transfer1 = new Transfer2(balance, count);
        for (int i = 0; i < 10000; i++) {
            new Thread(transfer1).start();
        }
        count.await();
        System.out.println(transfer1.balance);
    }


    @Override
    public void run() {
        lock.lock();
        balance++;
        lock.unlock();
        count.countDown();
    }

}
