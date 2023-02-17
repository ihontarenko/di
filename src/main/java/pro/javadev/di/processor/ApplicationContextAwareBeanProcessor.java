package pro.javadev.di.processor;

import pro.javadev.di.ApplicationContextAware;

public class ApplicationContextAwareBeanProcessor implements BeanProcessor {

    @Override
    public void process(Object object) {
        if (object instanceof ApplicationContextAware bean) {
            bean.setApplicationContext(null);
        }
    }

}
