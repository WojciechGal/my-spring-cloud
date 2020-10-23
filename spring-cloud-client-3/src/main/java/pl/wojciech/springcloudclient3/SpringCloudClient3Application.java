package pl.wojciech.springcloudclient3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.SendTo;
import pl.wojciech.springcloudclient3.converter.TextPlainMessageConverter;
import pl.wojciech.springcloudclient3.model.LogMessage;

@SpringBootApplication
@EnableBinding(Processor.class)
public class SpringCloudClient3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClient3Application.class, args);
    }

    //todo check: health, 5672 connection, messageconverter to text plain, group of input

    @Bean
    public MessageConverter providesTextPlainMessageConverter() {
        return new TextPlainMessageConverter();
    }

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public LogMessage enrichLogMessage(LogMessage log) {
        return new LogMessage(String.format("[1]: %s", log.getMessage()));
    }

}
