package com.ty.textilestockmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class TextileStockManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextileStockManagementApplication.class, args);
	}
	
	@SuppressWarnings("rawtypes")
	List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
	Contact contact = new Contact("vikas", "https://testyentra.com", "vikas.k@mail.com");
	
	ApiInfo apiInfo = new ApiInfo("Test Yentra Hospital App",
				"API's to person all actions related to book a hospital",
				"Snapshot-0.0.1", "https://testyantraglobal.com/", 
				contact, 
				"www.ty.com", 
				"terms and conditions",
				vendorExtensions);
	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ty"))
				.build()
				.apiInfo(apiInfo);
	}
}
