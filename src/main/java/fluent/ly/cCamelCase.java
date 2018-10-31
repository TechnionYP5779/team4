package fluent.ly;

import org.jetbrains.annotations.*;

/** An empty {@code interface} for fluent programming. The name should say it
 * all: The name, followed by a dot, followed by a method name, should read like
 * a sentence phrase.
 * @author Yossi Gil
 * @since 2016 */
public interface cCamelCase {
  static String[] components(final @NotNull String javaName) {
    return javaName.split(JAVA_CAMEL_CASE_SEPARATOR);
  }

  @SuppressWarnings("null") static String lastComponent(final Class<?> ¢) {
    return lastComponent(¢.getCanonicalName());
  }

  static String lastComponent(final @NotNull String fullClassName) {
    return fullClassName.replaceAll("[a-z0-9A-Z]*\\.", "");
  }

  static boolean usefulTypeName(final @NotNull String typeName) {
    return typeName.length() > 1 || !Character.isUpperCase(the.characterOf(typeName));
  }

  String JAVA_CAMEL_CASE_SEPARATOR = "[_]|(?<!(^|[_A-Z]))(?=[A-Z])|(?<!(^|_))(?=[A-Z][a-z])";
}
