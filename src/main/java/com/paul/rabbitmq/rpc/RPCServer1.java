package com.paul.rabbitmq.rpc;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class RPCServer1 {

	private static String REQUEST_QUEUE = "rpc_queue";

	private static Long fib(Long n) {
		if (n == 0)
			return 0L;
		if (n == 1)
			return 1L;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Channel channel = null;
		try {
			connectionFactory = new ConnectionFactory();
			connectionFactory.setHost("localhost");

			connection = connectionFactory.newConnection();
			channel = connection.createChannel();

			channel.queueDeclare(REQUEST_QUEUE, false, false, false, null);

			channel.basicQos(1);
			
			QueueingConsumer consumer = new QueueingConsumer(channel);

			channel.basicConsume(REQUEST_QUEUE, false, consumer);

			System.out.println("[x] Awaiting RPC requests");

			while (true) {

				String response = null;
				Delivery delivery = consumer.nextDelivery();

				String message = new String(delivery.getBody(), "UTF-8");

				response = Long.toString(fib(Long.valueOf(message)));

				System.out.println("[*] RPC request is fib(" + message + "), and answer is " + response);

				String correlationId = delivery.getProperties().getCorrelationId();
				String replay_queue = delivery.getProperties().getReplyTo();
				BasicProperties basicProperties = new BasicProperties.Builder().correlationId(correlationId).build();
				channel.basicPublish("", replay_queue, basicProperties, response.getBytes("UTF-8"));
				channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
