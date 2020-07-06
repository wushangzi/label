package core;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chengyongjun
 * @date 7/4/20 9:53 AM
 */
public class BackGroundThread {
    private static ExecutorService ex;

    {
        int cpu = Runtime.getRuntime ().availableProcessors ();
        if (cpu > 4) {

        }
        //ex = new ThreadPoolExecutor ()
    }
}
