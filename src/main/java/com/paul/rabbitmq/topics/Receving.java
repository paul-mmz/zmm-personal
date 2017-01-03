package com.paul.rabbitmq.topics;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receving {

	private static String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "topic");

		String queueName = channel.queueDeclare().getQueue();

		for (String s : args) {
			channel.queueBind(queueName, EXCHANGE_NAME, s);
		}
		System.out.println("[*] waiting for message. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				System.out.println("[xx] new implemention: receving message:");
				System.out.println("[**] '" + new String(body, "UTF-8") + "'");
			}
		};

		channel.basicConsume(queueName, true, consumer);
	}

}
