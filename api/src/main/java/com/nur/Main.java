package com.nur;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import com.nur.repositories.*;
import com.nur.repositories.characteristicProperty.CharacteristicPropertyJpaRepository;
import com.nur.repositories.propiedad.PropertyJpaRepository;
import com.nur.repositories.characteristic.CharacteristicJpaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.Arrays;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = { "com.nur.repositories" })
@OpenAPIDefinition(info = @Info(title = "Domain", version = "1.0.0"))
@EntityScan(basePackages = { "com.nur.model" })
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Primary
	@Bean(name = "propiedadRepository")
	public PropertyRepository propiedadRepository() {
		return new PropertyJpaRepository();
	}

	@Primary
	@Bean(name = "tipoPropiedadRepository")
	public CharacteristicRepository tipoPropiedadRepository() {
		return new CharacteristicJpaRepository();
	}

	@Primary
	@Bean(name = "characteristicPropertyRepository")
	public CharacteristicPropertyRepository characteristicPropertyRepository() {
		return new CharacteristicPropertyJpaRepository();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
		};
	}

	@Bean
	Pipeline pipeline(ObjectProvider<Command.Handler> commandHandlers,
			ObjectProvider<Notification.Handler> notificationHandlers, ObjectProvider<Command.Middleware> middlewares) {
		return new Pipelinr().with(commandHandlers::stream).with(notificationHandlers::stream)
				.with(middlewares::orderedStream);
	}

}
