import com.federecio.dropwizard.swagger.SwaggerDropwizard;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Configuration>
{
    private final SwaggerDropwizard swaggerDropwizard = new SwaggerDropwizard();

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        swaggerDropwizard.onInitialize(bootstrap);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new Resource());
        swaggerDropwizard.onRun(configuration, environment);
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
