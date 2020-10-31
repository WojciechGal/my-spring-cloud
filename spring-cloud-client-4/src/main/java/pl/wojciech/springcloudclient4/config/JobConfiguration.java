package pl.wojciech.springcloudclient4.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Slf4j
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job firstJob() {
        return this.jobBuilderFactory.get("job_1")
                .start(step_1())
                .next(step_2())
                .build();
    }

    @Bean
    public Job secondJob() {
        return jobBuilderFactory.get("job_2")
                .start(stepBuilderFactory.get("job_2_step_X")
                        .tasklet((contribution, chunkContext) -> {
                            log.info("Ping from step X in job second");
                            return RepeatStatus.FINISHED;
                        })
                        .build())
                .build();
    }

    @Bean
    public Step step_1() {
        return this.stepBuilderFactory.get("job_1_step_1")
            .tasklet((contribution, chunkContext) -> {
                log.info("Tasklet in step first has run");
                return RepeatStatus.FINISHED;
            }).build();
    }

    @Bean
    public Step step_2() {
        return this.stepBuilderFactory
            .get("job_1_step_2")
            .<String, String> chunk(3)
            .reader(
                new ListItemReader<>(Arrays.asList("7",
                    "2", "3", "10", "5", "6")))
            .processor(
                    (ItemProcessor<String, String>) item -> {
                        log.info("Processing of chunks in second step");
                        String value =  String.valueOf(Integer.parseInt(item) * 2);
                        log.info("Chunk processed value:{}", value);
                        return value;
                    })
            .writer(items -> {
                log.info("Writing items in second step");
                for (String item : items) {
                    log.info(">> " + item);
                }
            }).build();
    }

}