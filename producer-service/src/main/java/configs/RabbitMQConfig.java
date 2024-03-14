package configs;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static constans.RabbitMQConstants.*;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue queue()
    {
        return new Queue(QUEUE_PRODUCT_LOG, false, false, false);
    }

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(EXCHANGE_MARKETPLACE, false, false);
    }

    @Bean
    public Binding binding()
    {
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(ROUTING_KEY_PRODUCT_LOG);
    }

}
