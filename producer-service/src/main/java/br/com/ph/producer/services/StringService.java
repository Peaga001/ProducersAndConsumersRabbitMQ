package br.com.ph.producer.services;

import configs.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static configs.RabbitMQConfig.EXCHANGE_MARKETPLACE;
import static configs.RabbitMQConfig.ROUTING_KEY_PRODUCT_LOG;

@Log4j2
@Service
public class StringService {

    private final RabbitTemplate $rabbitTemplate;

    public StringService(RabbitTemplate $rabbitTemplate) {
        this.$rabbitTemplate = $rabbitTemplate;
    }

    public void produce(String $message)
    {
        log.info("Received message " + $message);
        $rabbitTemplate.convertAndSend(EXCHANGE_MARKETPLACE, ROUTING_KEY_PRODUCT_LOG,  $message);
    }
}
