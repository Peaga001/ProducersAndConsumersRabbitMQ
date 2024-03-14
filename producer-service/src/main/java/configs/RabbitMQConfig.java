package configs;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_MARKETPLACE    = "marketplace.direct";
    public static final String QUEUE_PRODUCT_LOG       = "product.log";
    public static final String ROUTING_KEY_PRODUCT_LOG = "product.log";

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
