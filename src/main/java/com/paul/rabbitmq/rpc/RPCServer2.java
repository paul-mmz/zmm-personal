package com.paul.rabbitmq.rpc;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class RPCServer2 {

	private static String REQUEST_QUEUE = "rpc_queue";

	private static Long fib(Long n) {
		if (n == 0)
			return 0L;
		if (n == 1)
			return 1L;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) throws IOException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection = connectionFactory.newConnection();
		final Channel channel = connection.createChannel();
		
		channel.queueDeclare(REQUEST_QUEUE, false, false, false, null);
		
		channel.basicQos(1);

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String correlationId = properties.getCorrelationId();
				String replay_queue = properties.getReplyTo();
				Long message = Long.valueOf(new String(body, "UTF-8"));

				String response = Long.toString(fib(message));

				System.out.println("[*] RPC request is fib(" + message + "), and answer is " + response);
				
				BasicProperties basicProperties = new BasicProperties.Builder().correlationId(correlationId).build();

				channel.basicPublish("", replay_queue, basicProperties, response.getBytes("UTF-8"));

				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};
		
		channel.basicConsume(REQUEST_QUEUE, false, consumer);
		
		System.out.println("[x] Awaiting RPC requesting");

	}

}
