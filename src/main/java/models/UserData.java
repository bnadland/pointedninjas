package models;

import javax.validation.constraints.*;

public class UserData {
	@NotNull
	@Size(min=3)
	public String name;
	@NotNull
	public String description;
}
