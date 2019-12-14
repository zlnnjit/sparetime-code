package top.bcoder.test.service.cas.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * FAA实现
 *
 * @author zln
 * @date 2019/12/12
 */
public class Transfer4 implements Runnable {

    private AtomicInteger balance;
    private CountDownLatch count;

    public Transfer4(AtomicInteger balance, CountDownLatch count) {
        this.balance = balance;
        this.count = count;
    }
    public static void main(String[] args) throws InterruptedException {
        //初始账户0源
        AtomicInteger balance = new AtomicInteger(0);

        //转账10000次，每次1元
        CountDownLatch count = new CountDownLatch(10000);
        Transfer4 transfer1 = new Transfer4(balance, count);
        for (int i = 0; i < 10000; i ++) {
            new Thread(transfer1).start();
        }
        count.await();
        System.out.println(transfer1.balance);
    }


    @Override
    public void run() {
        balance.addAndGet(1);
        count.countDown();
    }
}
