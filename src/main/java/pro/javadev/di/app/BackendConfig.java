package pro.javadev.di.app;

import pro.javadev.di.Bean;
import pro.javadev.di.Configuration;
import pro.javadev.di.PackagesForScan;

@Configuration
@PackagesForScan(baseClasses = Process.class)
public class BackendConfig {

    @Bean
    public String backendName() {
        return "backend_test_app";
    }

}
