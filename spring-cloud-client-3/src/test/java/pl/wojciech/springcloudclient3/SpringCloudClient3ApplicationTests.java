package pl.wojciech.springcloudclient3;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.wojciech.springcloudclient3.model.LogMessage;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringCloudClient3Application.class)
@DirtiesContext
class SpringCloudClient3ApplicationTests {

    @Autowired
    private Processor pipe;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MessageCollector messageCollector;

    @Test
    void contextLoads() {
    }

    @Test
    public void whenSendMessage_thenResponseShouldUpdateText() {
        pipe.input()
                .send(MessageBuilder.withPayload(new LogMessage("Hello!"))
                        .build());

        Object payload = Objects.requireNonNull(messageCollector
                .forChannel(pipe.output())
                .poll())
                .getPayload();

        assertEquals("{\"message\":\"[1]: Hello!\"}", payload.toString());
    }
}
