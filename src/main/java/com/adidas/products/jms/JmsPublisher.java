package com.adidas.products.jms;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.adidas.products.model.Product;

@Component
public class JmsPublisher {

    @Autowired
    private JmsTemplate template;

    @Value("${product.rest.target.queue}")
    private String targetQueue;

    private static final Logger LOGGER = Logger.getLogger("Adidas");

    /**
     * Method to send message to target queue for persistence.
     * 
     * @param product
     *            source object to persist.
     */
    public void sendMessageForStorage(Product product) {
        LOGGER.log(Level.INFO, "Sending message for persistence");
        template.convertAndSend(targetQueue, product);
    }
}
