package models;

import java.util.Map;
import com.google.inject.Inject;
import org.pegdown.PegDownProcessor;
import org.pegdown.Extensions;

public class User implements UserService {
	@Inject
	RedisService r;
	public Map<String, String> get(String id) {
		Map<String, String> u = r.connection().hgetAll(r.prefix("user").concat(id));
		PegDownProcessor p = new PegDownProcessor(Extensions.ALL);
		if(u.containsKey("description")) {
			u.put("description", p.markdownToHtml(u.get("description")));
		} else {
			u.put("description", "");
		}
		return u;
	}

	public void set(String id, String description) {
		r.connection().hset(r.prefix("user").concat(id), "id", id);
		r.connection().hset(r.prefix("user").concat(id), "name", id);
		r.connection().hset(r.prefix("user").concat(id), "description", description);
		setPassword(id, "1234");
	}

	protected void setPassword(String id, String password) {
		r.connection().set(r.prefix("password").concat(id), password);
	}

	public boolean validate(String id, String password) {
		if(password.equals(r.connection().get(r.prefix("password").concat(id)))) return true;
		return false;
	}
}
