package com.adidas.products.controller;

import static com.adidas.products.controller.ProductValidator.isProductValid;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.products.jms.JmsPublisher;
import com.adidas.products.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOGGER = Logger.getLogger("Adidas");

    @Autowired
    private JmsPublisher publisher;

    /**
     * Helper object to read input string from REST request and convert to model.
     */
    ObjectMapper mapper = new ObjectMapper();

    /**
     * Endpoint to receive REST request to first validate the product
     * and send further for persistence if valid.
     * @param request - source request object.
     * @return product equivalent of source.
     */
    @PostMapping("/save")
    public Product processProduct(@RequestBody String request) {
        ObjectNode node = null;
        try {
            node = mapper.readValue(request, ObjectNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = mapper.convertValue(node, Product.class);
        LOGGER.log(Level.INFO, "Product Received");
        if (isProductValid(product)) {
            LOGGER.log(Level.INFO, "Product Verified");
            publisher.sendMessageForStorage(product);
        }
        return product;
    }
}
