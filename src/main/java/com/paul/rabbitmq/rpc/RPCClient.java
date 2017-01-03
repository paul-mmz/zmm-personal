package com.paul.rabbitmq.rpc;

import java.io.IOException;
import java.util.UUID;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class RPCClient {

	private static String REQUEST_QUEUE = "rpc_queue";

	private String replay_queue = null;

	private ConnectionFactory connectionFactory = null;

	private Connection connection = null;

	private Channel channel = null;
	
	private QueueingConsumer consumer = null;

	public RPCClient() throws Exception {
		connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		connection = connectionFactory.newConnection();
		channel = connection.createChannel();
		replay_queue = channel.queueDeclare().getQueue();
		
		consumer = new QueueingConsumer(channel);
		channel.basicConsume(replay_queue, true, consumer);
	}

	public String call(String message) throws Exception {
		String correlationId = UUID.randomUUID().toString();
		String response = null;
		BasicProperties basicProperties = new BasicProperties.Builder().correlationId(correlationId)
				.replyTo(replay_queue).build();

		channel.basicPublish("", REQUEST_QUEUE, basicProperties, message.getBytes("UTF-8"));

		while (true) {
			Delivery delivery = consumer.nextDelivery();

			if (delivery.getProperties().getCorrelationId().equals(correlationId)) {
				response = new String(delivery.getBody(), "UTF-8");
				break;
			}
		}

		return response;
	}

	public void close() throws IOException {
		channel.close();
		connection.close();
	}

	public static void main(String[] args) {

		RPCClient rpcClient = null;

		try {
			rpcClient = new RPCClient();
			String response = null;
			System.out.println("[x] Requesting fib(30)");
			response = rpcClient.call("30");
			System.out.println("[*] Got the answer: " + response);
		} catch (Exception e) {
			System.err.println("RPC ERROR!");
			e.printStackTrace();
		} finally {
			try {
				rpcClient.close();
			} catch (IOException e) {
				System.err.println("CLOSE CONNECTION/CHANNEL ERROR!");
				e.printStackTrace();
			}
		}

	}
}
