package com.paul.rabbitmq.helloWorld;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receving {

	private static String QUEUE_NAME = "paul";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		System.out.println("[*] waiting for message. To exit press CTRL+C");

		// QueueingConsumer consumer = new QueueingConsumer(channel);

		Consumer consumer = new DefaultConsumer(channel) {
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				System.out.println("[xx] new implemention: receving message:");
				System.out.println("[**] '" + new String(body , "UTF-8") + "'");
			}
		};

		channel.basicConsume(QUEUE_NAME, true, consumer);

		// while (true) {
		//
		// Delivery delivery = consumer.nextDelivery();
		// String message = new String(delivery.getBody(), "UTF-8");
		// System.out.println("[x] Received '" + message + "'");
		// }
	}

}
