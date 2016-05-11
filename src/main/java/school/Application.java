/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package school;

import org.neo4j.ogm.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.neo4j.NodeEntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@NodeEntityScan(basePackages = "school.domain")
public class Application {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

    // Note that at the moment, spring boot's neo4j autoconfiguration does not detect "https" as a valid URI scheme,
    // as defined in application.properties, so we need to manually create the OGM Configuration bean if we want
    // to connect over https instead of http.
    //
    // Also, note that for the https connection to succeed you must install and configure a valid certificate and
    // configure the server to use it.
    //
    // The simplest thing to do (though not in a production environment!) is to install Neo's self-signed snakeoil.cert
    // (in conf/ssl) into your JVMs cacerts trust store.
    //
    @Bean
    Configuration configuration() {

        Configuration configuration = new Configuration();
        configuration.driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .setURI("https://neo4j:password@localhost:7473");
        return configuration;
    }

}
