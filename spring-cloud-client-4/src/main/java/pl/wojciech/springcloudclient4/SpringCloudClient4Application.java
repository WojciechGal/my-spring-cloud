package pl.wojciech.springcloudclient4;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
@EnableBatchProcessing
public class SpringCloudClient4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClient4Application.class, args);
	}

}
