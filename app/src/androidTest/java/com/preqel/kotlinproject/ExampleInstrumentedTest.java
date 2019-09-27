package com.preqel.kotlinproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,1000,1000, TimeUnit.SECONDS,null);
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
        assertEquals("com.preqel.kotlinproject", appContext.getPackageName());
    }
}
