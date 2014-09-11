package models;

import java.util.Map;
import redis.clients.jedis.Jedis;
import services.UserService;

public class User implements UserService {
	protected static String prefix = "kuband:users:";

	public Map<String, String> get(String pId) {
		return (new Jedis("localhost")).hgetAll(User.prefix.concat(pId));
	}
}
