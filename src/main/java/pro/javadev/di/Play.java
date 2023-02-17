package pro.javadev.di;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Play {

    public static void main(String... arguments) throws InvocationTargetException, IllegalAccessException {
        test();

//        Context context = ApplicationContext.run(Play.class);
    }

    public static void test() {
        Set<Class<?>> services = new Reflections("pro.javadev").getTypesAnnotatedWith(Bean.class);

        for (Class<?> service : services) {
            System.out.println(service);
        }

        Set<Class<?>> configurations = new Reflections(Play.class).getTypesAnnotatedWith(Configuration.class);

        for (Class<?> configuration : configurations) {

            System.out.println(configuration);

            for (Method method : configuration.getMethods()) {
                method.isAnnotationPresent(Bean.class);
            }
        }

        Set<Method> beans = new Reflections("pro.javadev").getMethodsAnnotatedWith(Bean.class);

        System.out.println(beans.size());

        for (Method bean : beans) {
            System.out.println("method bean");
            System.out.println(bean);
        }

        Reflections r       = new Reflections("pro.javadev", Scanners.values());
        Set<Method> methods = r.getMethodsAnnotatedWith(Bean.class);

        for (Method method : methods) {
            System.out.println(method);
        }
    }

}
