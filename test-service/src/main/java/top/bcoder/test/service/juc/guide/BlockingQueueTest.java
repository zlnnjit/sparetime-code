package top.bcoder.test.service.juc.guide;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author zln
 * @date 2019/12/25
 */
public class BlockingQueueTest {

    @Test
    public void testPutForArray() throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 6; i++) {
            arrayBlockingQueue.put(i);
            //阻塞
            System.out.println("put插入了：" + i);
        }
    }
    @Test
    public void testAddForArray() {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 6; i++) {
            arrayBlockingQueue.add(i);
            //异常
            System.out.println("add插入了：" + i);
        }
    }

    @Test
    public void testOfferForArray() {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(5);
        for (int i = 0; i < 6; i++) {
            System.out.println("offer插入了：" + i + "插入是否成功：" + arrayBlockingQueue.offer(i));
        }

        for (int i = 0; i < 6; i++) {
            System.out.println("poll获取了：" + i + "取值是否成功：" + arrayBlockingQueue.poll());
        }
    }

}
