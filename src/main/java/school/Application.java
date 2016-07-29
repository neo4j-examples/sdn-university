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

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.event.AfterDeleteEvent;
import org.springframework.data.neo4j.event.AfterSaveEvent;
import org.springframework.data.neo4j.event.BeforeSaveEvent;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "school.repository")
public class Application extends Neo4jConfiguration {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

    /**
     * Creates a neo4j configuration, falling back to embedded if config details not present
     */
    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
        org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
        config.driverConfiguration().setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver");
        config.driverConfiguration().setURI("http://neo4j:h4ckM3@localhost:7474");
        return config;
    }


    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(getConfiguration(), "school.domain");
    }

    public Session getSession() throws Exception {
        return super.getSession();
    }


    @Bean
    ApplicationListener<BeforeSaveEvent> beforeSaveEventApplicationListener() {
        return new ApplicationListener<BeforeSaveEvent>() {
            @Override
            public void onApplicationEvent(BeforeSaveEvent event) {
                Object entity = event.getEntity();
                System.out.println("Before save of: " + entity);
            }
        };
    }

    @Bean
    ApplicationListener<AfterSaveEvent> afterSaveEventApplicationListener() {
        return new ApplicationListener<AfterSaveEvent>() {
            @Override
            public void onApplicationEvent(AfterSaveEvent event) {
                Object entity = event.getEntity();
                System.out.println("Before save of: " + entity);
            }
        };
    }

    @Bean
    ApplicationListener<AfterDeleteEvent> deleteEventApplicationListener() {
        return new ApplicationListener<AfterDeleteEvent>() {
            @Override
            public void onApplicationEvent(AfterDeleteEvent event) {
                Object entity = event.getEntity();
                System.out.println("Before save of: " + entity);
            }
        };
    }

}
