package fluent.ly;

import java.lang.management.*;
import java.lang.reflect.*;
import java.util.*;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

/** A class to print all properties of an arbitrary object which can be
 * retrieved by getters methods (i.e., getXXX()) methods and boolean inspection
 * methods (i.e., isXXX()), as can be determined by reflection information.
 * @author Yossi Gil
 * @since 24/07/2007 */
@SuppressWarnings("null") public class dump {
  /** Dump a class object
   * @param ¢ JD */
  public static void go(final @NotNull Class<?> ¢) {
    out.out_message("\n\n--IDENTIFICATION--\n");
    out.out_object("Simple Name", ¢.getSimpleName());
    out.out_object("Canonical Name", ¢.getCanonicalName());
    out.out_object("Name", ¢.getName());
    out.out_object("toString", ¢ + "");
    out.out_object("super class", ¢.getSuperclass());
    out.out_object("generic super class", ¢.getGenericSuperclass());
    out.out_object("class", ¢.getClass());
    out.out_object("component type", ¢.getComponentType());
    // out("protection domain", c.getProtectionDomain());
    out.out_object("class loader", ¢.getClassLoader());
    out.out_message("--MODIFIERS--\n");
    final int flags = ¢.getModifiers();
    out.out_object("Package", ¢.getPackage());
    out.out_integer("Modifiers (decimal form)", flags);
    out.out_object("Modifiers (binary form)", ReflectionAnalyzer.toBinary(flags));
    out.out_message("IsSynthetic", ¢.isSynthetic());
    out.out_message("IsPrimitive", ¢.isPrimitive());
    out.out_message("IsFinal", Modifier.isFinal(flags));
    out.out_message("IsAbstract", Modifier.isAbstract(flags));
    out.out_message("IsStatic", Modifier.isStatic(flags));
    out.out_message("IsStrictfp", Modifier.isStrict(flags));
    out.out_message("--Visibility--\n");
    out.out_message("IsPublic", Modifier.isPublic(flags));
    out.out_message("IsPrivate", Modifier.isPrivate(flags));
    out.out_message("IsProtected", Modifier.isProtected(flags));
    out.out_message("--MEMBERS\n");
    out.out_object_array("fields", ¢.getFields());
    out.out_object_array("methods", ¢.getMethods());
    out.out_object_array("constructors", ¢.getConstructors());
    out.out_object_array("declared fields", ¢.getDeclaredFields());
    out.out_object_array("declared methods", ¢.getDeclaredMethods());
    out.out_object_array("declared constructors", ¢.getDeclaredConstructors());
    out.out_message("--CLASS SIGNATURE--\n");
    out.out_object_array("interfaces", ¢.getInterfaces());
    out.out_object_array("annotations", ¢.getAnnotations());
    out.out_object_array("type parameters", ¢.getTypeParameters());
    out.out_object_array("declared annotations", ¢.getDeclaredAnnotations());
    out.out_object_array("generic interfaces", ¢.getGenericInterfaces());
    out.out_message("--CONTAINERS--\n");
    out.out_object_array("declared classes", ¢.getDeclaredClasses());
    out.out_object("declaring class", ¢.getDeclaringClass());
    out.out_object("enclosing class", ¢.getEnclosingClass());
    out.out_object("enclosing constructor", ¢.getEnclosingConstructor());
    out.out_object("enclosing method", ¢.getEnclosingMethod());
    out.out_message("--CLASS MEMBERS--\n");
    out.out_object_array("public classes", ¢.getClasses());
    out.out_object_array("declared classes", ¢.getDeclaredClasses());
    out.out_object_array("declared annotations", ¢.getDeclaredAnnotations());
    out.out_message("---------------------------\n");
  }

  public static <T> void go(final @NotNull List<T> ts, final @NotNull String... ss) {
    out.out_message("Exploring list");
    for (final @NotNull String ¢ : ss)
      out.out_message(¢);
    for (final T ¢ : ts)
      dump.go(¢);
  }

  public static void go(final Object os[], final @NotNull String... ss) {
    for (final @NotNull String ¢ : ss)
      out.out_message(¢);
    out.out_object_array("elements", os);
  }

  public static void go(final @Nullable Object o, final @NotNull String... ss) {
    for (final @NotNull String ¢ : ss)
      out.out_message(¢);
    if (o == null) {
      out.out_message("NULL");
      return;
    }
    final Class<?> c = o.getClass();
    out.out_message("\n\n--BEGIN " + c.getSimpleName() + " object: " + o + "\n");
    out.out_object("Class canonical name", c.getCanonicalName());
    out.out_object("Class name", c.getName());
    for (final @NotNull Method m : c.getMethods()) {
      if (m.getParameterTypes().length != 0)
        continue;
      String name = m.getName();
      if ("getClass".equals(name) || "toString".equals(name))
        continue;
      if (name.matches("^get[A-Z].*$"))
        name = name.replaceFirst("^get", "");
      else if (name.matches("^is[A-Z].*$"))
        name = name.replaceFirst("^is", "");
      else if ("size".equals(name))
        name = "size";
      else if (!name.matches("^to[A-Z].*$"))
        continue;
      try {
        final Object $ = m.invoke(o);
        if ($ == null) {
          out.out_object(name, "null");
          continue;
        }
        if ($ instanceof Object[])
          out.out_object_array(name, (Object[]) $);
        out.out_object(name, !($ instanceof Collection) ? $ : (Collection<?>) $);
      } catch (final Throwable ¢) {
        // For some reason, a reflection call to method
        // getContent() in URL objects throws this exception.
        // We do not have much to do in this and other similar cases.
        out.out_object(name, m.getName() + " THROWS " + ¢);
      }
    }
    out.out_message("--END OBJECT--\n\n");
    System.out.flush();
  }

  public static void main(final @NotNull String[] args) {
    // Explore.go(Package.class);
    final ClassLoadingMXBean a = ManagementFactory.getClassLoadingMXBean();
    System.out.println(a.getLoadedClassCount());
    System.out.println(a.getTotalLoadedClassCount());
    System.out.println(a.getUnloadedClassCount());
    dump.go(ManagementFactory.getClassLoadingMXBean());
    final CompilationMXBean b = ManagementFactory.getCompilationMXBean();
    System.out.println(b.getTotalCompilationTime());
    System.out.println(b.getName());
    System.out.println(b.isCompilationTimeMonitoringSupported());
    System.exit(1);
    dump.go(ManagementFactory.getGarbageCollectorMXBeans());
    dump.go(ManagementFactory.getMemoryManagerMXBeans());
    dump.go(ManagementFactory.getMemoryPoolMXBeans());
    dump.go(ManagementFactory.getOperatingSystemMXBean());
    dump.go(ManagementFactory.getPlatformMBeanServer());
    dump.go(ManagementFactory.getRuntimeMXBean());
    dump.go(ManagementFactory.getThreadMXBean());
  }
}
