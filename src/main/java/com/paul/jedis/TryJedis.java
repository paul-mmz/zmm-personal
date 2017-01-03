package com.paul.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TryJedis {

	public static JedisPool jedisPool;

	public static void main(String[] args) {

		try {
			jedisPool = new JedisPool(new JedisPoolConfig(), "localhost");
			Jedis jedis = jedisPool.getResource();
			jedis.set("foo", "shit");
			System.out.println(jedis.get("foo"));
		} finally {
			if (jedisPool != null)
				jedisPool.close();
		}

	}
}
