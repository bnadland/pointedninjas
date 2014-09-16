package conf;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.Inject;
import ninja.UsernamePasswordValidator;
import models.User;
import models.UserService;
import models.Redis;
import models.RedisService;

@Singleton
public class Module extends AbstractModule {
    
	@Override
    protected void configure() {
        bind(UserService.class).to(User.class);
        bind(RedisService.class).to(Redis.class);
		bind(UsernamePasswordValidator.class).toInstance(new UsernamePasswordValidator() {
			@Inject
			UserService user;
			@Override
			public boolean validateCredentials(String username, String password) {
				return user.validate(username, password);
			}
		});
    }

}
