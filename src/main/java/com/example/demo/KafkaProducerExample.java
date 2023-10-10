package com.example.demo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.Properties;
@SpringBootApplication
public class KafkaProducerExample {
	public static void main(String[] args) throws Exception {

		// Load producer properties from file
		Properties producerProps = new Properties();
		FileInputStream fis = new FileInputStream("/home/ljh/Downloads/demo/src/main/resources/application.properties");
		producerProps.load(fis);

		// Set producer properties
		String bootstrapServers = producerProps.getProperty("bootstrap.servers");
		int batchSize = Integer.parseInt(producerProps.getProperty("batch.size"));
		int buffer = Integer.parseInt(producerProps.getProperty("buffer.memory"));
		String topic = producerProps.getProperty("topic");

		// ... set other producer properties

		// Create Kafka producer instance with configured properties
		Producer<String, String> producer = new KafkaProducer<>(producerProps);

		for(int i = 0; i < 2; ++i) {
			Thread.sleep(1000L);
			System.out.printf("%d\n", i);
			producer.send(new ProducerRecord(topic,Integer.toString(batchSize), Integer.toString(buffer)));
		}
		// ... use producer to send messages
	}
}
