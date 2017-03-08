import com.google.inject.AbstractModule;

/**
 * Created by jeff on 2017-03-07.
 */
public class Module extends AbstractModule {
  @Override protected void configure() {
    bind(HelloWorldService.class);
  }
}
