import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecServiceTesting {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        
        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Runnable Execution: "+Thread.currentThread().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Tasks execution: "+Thread.currentThread().toString();
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        es.execute(runnableTask);

        String res = null;
        Future<String> f = es.submit(callableTask);
        try{
            res = f.get();
            System.out.println(res);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        res = es.invokeAny(callableTasks);
        System.out.println("InvokeAny Result: "+res);

        List<Future<String>> lf = es.invokeAll(callableTasks, 10_000, TimeUnit.MILLISECONDS);
        for(Future<String> r : lf) {
            System.out.println("InvokeAll Resultset: " + r.get());
        }

        es.shutdown();
        // es.shutdownNow(); return List<Runnable> of not executed tasks
        try {
            if(!es.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                es.shutdownNow();
            }
        } catch(InterruptedException e) {
            es.shutdownNow();
        }
    }
}
