package util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xiejiedun on 2018/12/14
 */
public class ThreadPoolUtil {
    private static ExecutorService validService = Executors.newFixedThreadPool(20);

    public static Future submit(Runnable runnable){
        return validService.submit(runnable);
    }
}
