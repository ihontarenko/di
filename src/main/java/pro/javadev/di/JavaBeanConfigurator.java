package pro.javadev.di;

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
public class JavaBeanConfigurator implements BeanConfigurator {

    private final Map<Class<?>, Map<String, Class<?>>> implementations = new HashMap<>();
    private final Reflections                          scanner;

    public JavaBeanConfigurator() {
        ConfigurationBuilder builder = new ConfigurationBuilder().addUrls();
        this.scanner = new Reflections(builder);
        new Reflections("builder", JavaBeanConfigurator.class);
    }

    @Override
    public <T> Class<? extends T> getImplementation(Class<T> type, String qualifier) {
        return (Class<? extends T>) implementations
                .computeIfAbsent(type, t -> new HashMap<>())
                .computeIfAbsent(qualifier, q -> scanner.getSubTypesOf(type).stream().findFirst().get());
    }

}
