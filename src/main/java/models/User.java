package models;

import java.util.Map;
import org.pegdown.PegDownProcessor;
import org.pegdown.Extensions;
import redis.clients.jedis.Jedis;
import services.UserService;

public class User implements UserService {
	protected static String prefix = "kuband:users:";

	public Map<String, String> get(String pId) {
		Map<String, String> u = (new Jedis("localhost")).hgetAll(User.prefix.concat(pId));
		PegDownProcessor p = new PegDownProcessor(Extensions.ALL);
		if(u.containsKey("description")) {
			u.put("description", p.markdownToHtml(u.get("description")));
		} else {
			u.put("description", "");
		}
		return u;
	}
}
