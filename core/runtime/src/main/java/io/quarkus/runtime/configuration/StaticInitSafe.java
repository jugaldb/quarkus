package io.quarkus.runtime.configuration;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Used to mark a {@link org.eclipse.microprofile.config.spi.ConfigSource},
 * {@link org.eclipse.microprofile.config.spi.ConfigSourceProvider} or {@link io.smallrye.config.ConfigSourceFactory}
 * as safe to be initialized during STATIC INIT.
 *
 * When a Quarkus application is starting up, Quarkus will execute first a static init method which contains some
 * extensions actions and configurations. Example:
 *
 * <pre>
 * // Auto Generated by Quarkus
 * public class Application {
 *     static {
 *         Config config = ConfigProvider.getConfig();
 *         String url = config.getValue("database.url", String.class);
 *         String login = config.getValue("database.login", String.class);
 *         String password = config.getValue("database.password", String.class);
 *
 *         initDatabase(url, login, password);
 *     }
 * }
 * </pre>
 *
 * Please check <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html">Initializing Fields</a> for
 * more information about static blocks.
 *
 * Since Config initializes first, some ConfigSources may not be suited to be initialized at static init. Consider the
 * previous code example and a ConfigSource that requires database access. In this case, it is impossible to properly
 * initialize such ConfigSource, because the database services are not yet available so the ConfigSource in unusable.
 */
@Target(TYPE)
@Retention(RUNTIME)
@Documented
public @interface StaticInitSafe {
}
