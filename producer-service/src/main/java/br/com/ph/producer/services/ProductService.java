package br.com.ph.producer.services;

import dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static constans.RabbitMQConstants.*;

@Log4j2
@Service
public class ProductService {

    private final RabbitTemplate $rabbitTemplate;

    public ProductService(RabbitTemplate $rabbitTemplate) {
        this.$rabbitTemplate = $rabbitTemplate;
    }

    public void createProduct(ProductDTO dto) {
        log.info("Sending a message to exchange " + dto.toString());
        $rabbitTemplate.convertAndSend(EXCHANGE_MARKETPLACE, ROUTING_KEY_PRODUCT_LOG, dto);
    }
}
