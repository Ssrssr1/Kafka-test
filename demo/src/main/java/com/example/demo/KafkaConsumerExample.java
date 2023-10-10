package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class KafkaConsumerExample {

    public static void main(String[] args) throws IOException {

        // Load consumer properties from file
        Properties consumerProps = new Properties();
        FileInputStream fis = new FileInputStream("/home/ljh/Downloads/demo/src/main/resources/application.properties");
        consumerProps.load(fis);

        // Create Kafka consumer instance with configured properties
        Consumer<String, String> consumer = new KafkaConsumer<>(consumerProps);
        // Subscribe to topic
        String topic = consumerProps.getProperty("topic");
        TopicPartition partition0 = new TopicPartition(topic, 0);
        consumer.assign(Arrays.asList(partition0));

        // Start consuming messages from topic
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Received message: " + "buffer:" + record.value()  +"\nbatchSize:" + record.key() + "\n");
                // ... process message
            }
        }
    }
}