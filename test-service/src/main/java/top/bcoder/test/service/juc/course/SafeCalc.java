package top.bcoder.test.service.juc.course;

import java.util.concurrent.TimeUnit;

class SafeCalc {
  private static long value = 0L;
  private long get() {
    return value;
  }
  private synchronized void addOne() {
    value += 1;
  }

  public static void main(String[] args) throws InterruptedException {
    SafeCalc safeCalc = new SafeCalc();
    Thread A = new Thread(() -> {
      safeCalc.addOne();
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      safeCalc.addOne();
    });
    Thread B = new Thread(() -> {
      System.out.println(safeCalc.get());
    });
    A.start();
    B.start();
    TimeUnit.SECONDS.sleep(5);
  }
}