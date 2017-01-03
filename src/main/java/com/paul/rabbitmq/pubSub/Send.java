package com.paul.rabbitmq.pubSub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private static String EXCHANGE_NAME = "logs";

	public static void main(String[] args) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		
		String message = com.paul.rabbitmq.workQueues.Send.getMessage(args);

		channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
		System.out.println("[x] Sent '" + message + "'");

		channel.close();
		connection.close();

	}

}
