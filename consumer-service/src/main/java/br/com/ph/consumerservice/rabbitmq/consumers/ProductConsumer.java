package br.com.ph.consumerservice.rabbitmq.consumers;

import constans.RabbitMQConstants;
import dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ProductConsumer {

    @RabbitListener(queues = {RabbitMQConstants.ROUTING_KEY_PRODUCT_LOG})
    public void consumer(ProductDTO message){
        log.info("Consumer received a message " + message.toString());
    }
}
