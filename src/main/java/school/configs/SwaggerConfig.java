package school.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;

/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {
	
	private SpringSwaggerConfig springSwaggerConfig;
	
	   @Autowired
	   public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
	      this.springSwaggerConfig = springSwaggerConfig;
	   }

	   @Bean //Don't forget the @Bean annotation
	   public SwaggerSpringMvcPlugin customImplementation(){
//		  AbsoluteSwaggerPathProvider pathProvider = new AbsoluteSwaggerPathProvider();
	      return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
	            .apiInfo(apiInfo())
//	            .pathProvider(pathProvider)
	            .includePatterns("/api/.*");
	   }

	    private ApiInfo apiInfo() {
	      ApiInfo apiInfo = new ApiInfo(
	              "sdn4-university Restful API",
	              "API for sdn4-university",
	              "sdn4-university API terms of service",
	              "youngwelle@gmail.com",
	              "sdn4-university API Licence Type",
	              "sdn4-university API License URL"
	        );
	      return apiInfo;
	    }
	    
}
