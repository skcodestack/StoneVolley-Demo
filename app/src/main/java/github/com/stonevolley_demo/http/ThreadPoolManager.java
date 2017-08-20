package github.com.stonevolley_demo.http;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public class ThreadPoolManager {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    // We want at least 2 threads and at most 4 threads in the core pool,
    // preferring to have 1 less than the CPU count to avoid saturating
    // the CPU with background work
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final int KEEP_ALIVE_SECONDS = 30;

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
        }
    };
    /**
     * 线程池管理
     * JDK1.5 之前不可以使用DCL(双锁检测)来实现单例
     */
    private  static volatile ThreadPoolManager manager=null;

    private LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue(128);
    private ThreadPoolExecutor threadPoolExecutor = null;

    /**
     * 单列模型
     * @return
     */
    private ThreadPoolManager(){

        threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS, TimeUnit.SECONDS,
                linkedBlockingQueue, sThreadFactory);
        threadPoolExecutor.execute(runnable);

    }
    /**
     * 获取对象
     * (双锁检测)来实现单例, JDK 1.5前 ，不可使用
     * @return
     */
    public  static   ThreadPoolManager  getInstance()
    {
        if(manager==null)
        {
            synchronized (ThreadPoolManager.class) {
                if(manager==null) {
                    manager = new ThreadPoolManager();
                }
            }
        }
        return  manager;
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Runnable task = null;
            while (true){

                try {

                    task = linkedBlockingQueue.take();

                } catch (InterruptedException e) {
                    e.printStackTrace();


                }

                if(task != null){

                    threadPoolExecutor.execute(task);

                }


            }


        }
    };


    public void execute(Runnable runnable) throws InterruptedException {



        linkedBlockingQueue.put(runnable);



    }




}
