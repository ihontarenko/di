package pro.javadev.di;

import java.util.Objects;

public class FileBeanConfigurator implements BeanConfigurator {

    @Override
    public <T> Class<? extends T> getImplementation(Class<T> type, String qualifier) {
        Class<? extends T> implementation = null;

        try {
            implementation = (Class<? extends T>) Class.forName(getClassName(type.getName(), qualifier));
        } catch (ClassNotFoundException e) {
            ExceptionSuppressor.throwException(e);
        }

        Objects.requireNonNull(implementation);

        return implementation;
    }

    private String getClassName(String className, String qualifier) {
        return null;
    }

}
