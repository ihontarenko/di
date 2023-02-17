package pro.javadev.di;

import java.lang.reflect.InvocationTargetException;

public class BeanFactory {

    private final BeanConfigurator configurator;

    public BeanFactory(BeanConfigurator configurator) {
        this.configurator = configurator;
    }

    public <T> T getBean(Class<T> type) {
        Class<? extends T> implementation = type;
        T                  instance       = null;

        if (implementation.isInterface()) {
            implementation = configurator.getImplementation(type);
        }

        try {
            instance = implementation.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            ExceptionSuppressor.throwException(e);
        }

        return instance;
    }

}
