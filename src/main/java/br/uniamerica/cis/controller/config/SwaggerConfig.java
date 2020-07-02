package br.uniamerica.cis.controller.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	
	
	@Primary
    @Bean     //Correção erro Spring Hateoas.
    public LinkDiscoverers thanksStackoverflow() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.uniamerica.cis"))
				.build()
				.apiInfo(metaData())
				.globalResponseMessage(RequestMethod.GET, responseMessageForGET())
				.globalResponseMessage(RequestMethod.POST, responseMessageForPOST())
				.globalResponseMessage(RequestMethod.PUT, responseMessageForPUT())
				.globalResponseMessage(RequestMethod.DELETE, responseMessageForDELETE());
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
		.title("Projeto CIS - API Documentation")
		.description("Exemplo simples de documentação no Swagger")
		.version("1.0.0")
		.license("Apache License Version 2.0")
		.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
		.build();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	private List<ResponseMessage> responseMessageForGET() {
        return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
			{
	            add(new ResponseMessageBuilder()
	                    .code(404)
	                    .message("Recurso não encontrado!")
	                    .build());
	        }
		};
    }
	
	private List<ResponseMessage> responseMessageForPOST() {
        return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
			{
	            add(new ResponseMessageBuilder()
	                    .code(201)
	                    .message("Recurso criado com sucesso")
	                    .build());
	            add(new ResponseMessageBuilder()
	                    .code(400)
	                    .message("Alguns dados no corpo da requisição podem estar ausentes ou inválidos")
	                    .build());
	        }
        };
    }
	
	private List<ResponseMessage> responseMessageForPUT() {
        return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
			{
	            add(new ResponseMessageBuilder()
	                    .code(400)
	                    .message("Alguns dados no corpo da requisição podem estar ausentes ou inválidos")
	                    .build());
	            add(new ResponseMessageBuilder()
	                    .code(404)
	                    .message("Recurso não encontrado!")
	                    .build());
	        }
		};
    }
	
	private List<ResponseMessage> responseMessageForDELETE() {
        return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
			{
	            add(new ResponseMessageBuilder()
	                    .code(204)
	                    .message("Recurso deletado com sucesso")
	                    .build());
	            add(new ResponseMessageBuilder()
	                    .code(404)
	                    .message("Recurso não encontrado!")
	                    .build());
	        }
		};
    }
}
