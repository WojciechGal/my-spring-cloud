package pl.wojciech.springcloudclient4.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

@Slf4j
public class CustomTaskListener implements TaskExecutionListener {

    @Override
    public void onTaskEnd(TaskExecution arg) {
        log.info("End of Task");
    }

    @Override
    public void onTaskFailed(TaskExecution arg0, Throwable arg1) {
        log.error("Failure of Task");
    }

    @Override
    public void onTaskStartup(TaskExecution arg) {
        log.info("Task Startup");
    }

}
