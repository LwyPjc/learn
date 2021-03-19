package concurrent.mythread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static class RunnableTask implements Runnable{
        static int i = 0;
        public RunnableTask(){

        }
        public RunnableTask(int i){
            this.i = i;
//            System.out.println(++this.i);
        }
        @Override
        public void run() {
            System.out.println("Runnable thread~"+ ++i);
        }
    }

    public static class CallerTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "hello";
        }
    }
    public static void main(String[] args) {

        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread((futureTask)).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }



        //创建线程
        MyThread thread = new MyThread();
        //启动线程
        thread.start();
        int i = 8;
        RunnableTask task = new RunnableTask(i);
        new Thread(task).start();
        new Thread(task).start();

    }
}
