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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import school.events.PostDeleteEvent;
import school.events.PostSaveEvent;
import school.events.PreSaveEvent;

@SpringBootApplication(exclude = Neo4jDataAutoConfiguration.class)
public class Application {

	public static void main(String[] args) {
		new SpringApplication(Application.class).run(args);
	}

    @Bean
    ApplicationListener<PreSaveEvent> beforeSaveEventApplicationListener() {
        return new ApplicationListener<PreSaveEvent>() {
            @Override
            public void onApplicationEvent(PreSaveEvent event) {
                Object entity = event.getSource();
                System.out.println("Before save of: " + entity);
            }
        };
    }

    @Bean
    ApplicationListener<PostSaveEvent> afterSaveEventApplicationListener() {
        return new ApplicationListener<PostSaveEvent>() {
            @Override
            public void onApplicationEvent(PostSaveEvent event) {
                Object entity = event.getSource();
                System.out.println("Before save of: " + entity);
            }
        };
    }

    @Bean
    ApplicationListener<PostDeleteEvent> deleteEventApplicationListener() {
        return new ApplicationListener<PostDeleteEvent>() {
            @Override
            public void onApplicationEvent(PostDeleteEvent event) {
                Object entity = event.getSource();
                System.out.println("Before save of: " + entity);
            }
        };
    }

}
