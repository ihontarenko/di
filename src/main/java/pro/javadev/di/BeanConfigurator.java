package pro.javadev.di;

public interface BeanConfigurator {

    <T> Class<? extends T> getImplementation(Class<T> type, String qualifier);

    default <T> Class<? extends T> getImplementation(Class<T> type) {
        return getImplementation(type, null);
    }

}
