package com.paul.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private static String EXCHANGE_NAME = "direct_logs";

	public static void main(String[] args) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		
		String message = args[0];

		for(int i = 1; i < args.length; ++i){
			channel.basicPublish(EXCHANGE_NAME, args[i], null, message.getBytes("UTF-8"));
			System.out.println("[x] Sent '" + message + "'");
			Thread.sleep(1000);
		}

		channel.close();
		connection.close();

	}

}
