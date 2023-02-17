package pro.javadev.di;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ApplicationContext {

    private final Map<Class<?>, Object> beans = new ConcurrentHashMap<>();
    private final BeanFactory factory;

    public ApplicationContext() {
        this.factory = new BeanFactory(new JavaBeanConfigurator());
    }

    @SuppressWarnings({"all"})
    public <T> T getBean(Class<T> type) {
        return (T) beans.computeIfAbsent(type, clazz -> factory.getBean(type));
    }

    public static ApplicationContext run(Class<?> rootClass) {
        return new ApplicationContext();
    }

}
