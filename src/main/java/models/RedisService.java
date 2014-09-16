package models;

import redis.clients.jedis.Jedis;

public interface RedisService {
	public Jedis connection();
	public String prefix(String type);
}
