package cv.base.sample.concurrency;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: xutu
 * @since: 2025/2/15 15:27
 */
public class CountDownLaunchSample {
    public static void main(String[] args) throws InterruptedException {
        // 简单使用
        System.out.println("============ step1 begin ============");
        simpleUse();
        // 进阶使用
        System.out.println("============ step2 begin ============");
        complexUse();
    }


    /**
     * 功能解析：
     * 	•	超时后返回 false：如果超时，await() 返回 false，表示超时。
     * 	•	计数器不变：计数器仍然保持原值，主线程仍然可以继续通过 countDown() 来减少计数器的值。
     * 	•	超时后继续执行：调用 await() 超时后，主线程会继续执行，并且如果需要，仍然可以等待其他线程完成或继续执行其他任务。
     *
     */
    private static void complexUse() throws InterruptedException {
        // 创建 CountDownLatch，计数器为 3
        CountDownLatch latch = new CountDownLatch(3);

        // 启动 3 个子线程
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            new Thread(() -> {
                try {
                    System.out.println("Task " + taskId + " is working...");
                    Thread.sleep(1000);  // 模拟任务执行时间
                    System.out.println("Task " + taskId + " is done.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        System.out.println("Main thread is waiting for tasks to finish.");

        // 主线程等待子线程执行完毕，最多等待 5 秒
        boolean finishedInTime = latch.await(5, TimeUnit.SECONDS);

        if (finishedInTime) {
            System.out.println("All tasks are done within the timeout.");
        } else {
            System.out.println("Timeout reached. Some tasks might not have finished.");
        }

    }

    /**
     * 功能解析：
     * •   主线程创建了一个 CountDownLatch，并设置计数器为 3，因为有 3 个子线程需要完成任务。
     * •	每个子线程执行任务后，通过 latch.countDown() 通知 CountDownLatch 该线程已经完成。
     * •	主线程调用 latch.await()，该方法会阻塞主线程，直到计数器的值变为 0（即 3 个子线程都调用了 countDown()）
     *
     * @throws InterruptedException
     */
    public static void simpleUse() throws InterruptedException {
        // 创建一个 CountDownLatch，初始计数器为 3
        CountDownLatch latch = new CountDownLatch(3);

        // 启动 3 个子线程
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            new Thread(() -> {
                try {
                    System.out.println("Task " + taskId + " is working...");
                    Thread.sleep(1000);  // 模拟任务执行时间
                    System.out.println("Task " + taskId + " is done.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();  // 每个线程完成任务后调用 countDown
                }
            }).start();
        }

        System.out.println("Main thread is waiting for tasks to finish.");

        // 主线程等待子线程执行完毕
        latch.await();  // 阻塞主线程，直到计数器为 0

        System.out.println("All tasks are done. Main thread resumes.");
    }


}
