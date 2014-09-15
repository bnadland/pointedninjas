package models;

import java.util.Map;
import org.pegdown.PegDownProcessor;
import org.pegdown.Extensions;
import redis.clients.jedis.Jedis;

public class User implements UserService {
	protected static String prefix = "kuband:users:";
	Jedis j = new Jedis("localhost");

	public Map<String, String> get(String id) {
		Map<String, String> u = j.hgetAll(User.prefix.concat(id));
		PegDownProcessor p = new PegDownProcessor(Extensions.ALL);
		if(u.containsKey("description")) {
			u.put("description", p.markdownToHtml(u.get("description")));
		} else {
			u.put("description", "");
		}
		return u;
	}

	public void set(String id, String description) {
		j.hset(User.prefix.concat(id), "id", id);
		j.hset(User.prefix.concat(id), "description", description);
	}
}
