package com.paul.rabbitmq.workQueues;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receving {

	private static String QUEUE_NAME = "task_queue";
	
	private static boolean AUTO_ACK = false;

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, true, false, false, null);

		System.out.println("[*] waiting for message. To exit press CTRL+C");

		channel.basicQos(1);
		
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				System.out.println("[xx] new implemention: receving message:");
				String message = new String(body , "UTF-8");
				System.out.println("[**] '" + message + "'");
				try{
					doWork(message);
				}finally{
					System.out.println("[x] Done");
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};

		channel.basicConsume(QUEUE_NAME, AUTO_ACK, consumer);
	}

	protected static void doWork(String message) {
		char[] charArray = message.toCharArray();
		for(char c : charArray){
			if(c == '.'){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
