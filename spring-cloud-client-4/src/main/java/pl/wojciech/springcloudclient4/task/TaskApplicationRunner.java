package pl.wojciech.springcloudclient4.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("HELLO FROM TASK APPLICATION RUNNER");
        log.info("Executing calculation task...");
        int c = add(1, 2);
        log.info("Task executed correctly, result is: {}", c);
        log.info("BYE FROM TASK APPLICATION RUNNER");
    }

    private static int add(int a, int b) {
        return a + b;
    }

}
