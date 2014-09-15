package models;

import java.util.Map;

public interface UserService {
	public Map<String, String> get(String pId);
	public void set(String pId, String description);
}
