package br.com.cadilam.producer_service.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import br.com.cadilam.producer_service.configs.RabbitMQConfig;
import br.com.cadilam.producer_service.dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO dto) {
        log.info("Sending a message to exchange " + dto.toString());

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_NAME_MARKETPLACE, RabbitMQConfig.RK_PRODUCT_LOG, dto);
    }
}
