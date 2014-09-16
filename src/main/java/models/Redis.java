package models;

import com.google.inject.Inject;
import ninja.utils.NinjaProperties;
import redis.clients.jedis.Jedis;

public class Redis implements RedisService {
	@Inject
	NinjaProperties config;

	public Jedis j = new Jedis("localhost");

	public Jedis connection() {
		return j;
	}

	public String prefix(String type) {
		return config.get("application.name")+":"+type+":";
	}
}
