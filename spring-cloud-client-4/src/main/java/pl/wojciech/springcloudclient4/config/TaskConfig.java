package pl.wojciech.springcloudclient4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojciech.springcloudclient4.listener.CustomTaskListener;

import javax.sql.DataSource;

@Configuration
public class TaskConfig {

    @Autowired
    private DataSource dataSource;

    //for not loosing task related data (they vanish once the task ends)
    public static class CustomTaskConfigurer extends DefaultTaskConfigurer {
        public CustomTaskConfigurer(DataSource dataSource){
            super(dataSource);
        }
    }

    @Bean
    public CustomTaskConfigurer getCustomTaskConfigurer() {
        return new CustomTaskConfigurer(dataSource);
    }

    @Bean
    public CustomTaskListener taskListener() {
        return new CustomTaskListener();
    }
}
