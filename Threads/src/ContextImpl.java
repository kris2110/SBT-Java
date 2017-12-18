import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by 11007122 on 16.12.2017.
 */
public class ContextImpl implements Context {
    private boolean isFinished;
    private ExecutorService pool;
    private List<Future> futures;
    private int amount;

    public ContextImpl(int amount, Runnable callback, Runnable... tasks) {
        this.isFinished = false;
        futures = new ArrayList<>();
        this.amount = amount;
        this.pool = Executors.newFixedThreadPool(amount);
        for(Runnable task: tasks) {
            futures.add(pool.submit(task));
        }
    }

    @Override
    public int getCompletedTaskCount() {
        int completedTasks = 0;
        for(Future future: futures) {
            if(future.isDone()){
                completedTasks++;
            }
        }
        return completedTasks;
    }

    @Override
    public int getFailedTaskCount() {
        int failedTasks = 0; //  в рантайме
        for(Future future: futures) {
            try {
                future.get();
            } catch (InterruptedException e) {}
              catch (ExecutionException e) {
                failedTasks++;
            }
        }
        return failedTasks;
    }

    @Override
    public int getInterruptedTaskCount() {
        int interruptedTasks = 0;
        for(Future future: futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                interruptedTasks++;
            } catch (ExecutionException e) {}
        }
        return interruptedTasks;
    }

    @Override
    public void interrupt() {
        for(Future future: futures) {
            future.cancel(false);
        }
    }

    @Override
    public boolean isFinished() {
        return (getCompletedTaskCount() + getFailedTaskCount() + getInterruptedTaskCount() == amount);
    }

}
