package com.preqel.kotlinproject;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        ExecutorService ex = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,1000,1000, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        threadPoolExecutor.getQueue().add(new Runnable() {
            @Override
            public void run() {
                System.out.println("helloo");
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("er");
            }
        });
        assertEquals(4, 2 + 2);
    }
}