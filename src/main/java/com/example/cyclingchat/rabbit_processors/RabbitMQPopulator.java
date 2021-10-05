package com.example.cyclingchat.rabbit_processors;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;


public class RabbitMQPopulator {


    private final static String QUEUE_NAME = "example-queue"; //the queue name is equal as the on that was defined in CyclingchatApplication.class
    private final static String HOST = "10.103.100.124"; //rabbitmq ip. In this case was used the CLUSTER-IP from Rabbitmq Service
    private final static String MESSAGE = "Good by";
    private final static int NUMBER_OF_MESSAGES_PER_SECOND = 100;

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername("rabbit");
        factory.setPassword("rabbit");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            while (true) {
                int i = 0;
                while (i < NUMBER_OF_MESSAGES_PER_SECOND) {
                    channel.basicPublish("", QUEUE_NAME, null, MESSAGE.getBytes(StandardCharsets.UTF_8));
                    i++;
                }

                System.out.println("Was sent " + NUMBER_OF_MESSAGES_PER_SECOND + " with the following content: '" + NUMBER_OF_MESSAGES_PER_SECOND + "'");

                Thread.sleep(1000);
            }

        }
    }
}