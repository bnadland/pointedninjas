package conf;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import models.User;
import models.UserService;

@Singleton
public class Module extends AbstractModule {
    
	@Override
    protected void configure() {
        bind(UserService.class).to(User.class);
    }

}
