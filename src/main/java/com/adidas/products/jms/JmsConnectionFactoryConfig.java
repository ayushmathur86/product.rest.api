package com.adidas.products.jms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConnectionFactoryConfig {

    @Value("${spring.activemq.broker-url}")
    private String mqUrl;

    @Value("${spring.activemq.user}")
    private String mqUser;

    @Value("${spring.activemq.password}")
    private String mqPassword;

    /**
     * Method to initialize ConnectionFactory for the queue.
     * 
     * @return instance of ConnectionFactory.
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(mqUrl);
        connectionFactory.setUserName(mqUser);
        connectionFactory.setPassword(mqPassword);
        return connectionFactory;
    }

    /**
     * Method to serialize message content to JSON.
     * 
     * @return instance of MessageConverter.
     */
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    /**
     * Method to initialize JmsTemplate for sending message to the queue.
     * @return instance of JmsTemplate.
     */
    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setMessageConverter(jacksonJmsMessageConverter());
        template.setConnectionFactory(connectionFactory());
        return template;
    }
}
