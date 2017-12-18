
/**
 * Created by 11007122 on 16.12.2017.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
