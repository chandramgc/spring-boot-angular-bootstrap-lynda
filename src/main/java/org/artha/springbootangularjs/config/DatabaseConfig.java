package org.artha.springbootangularjs.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("org.artha.springbootangularjs.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
