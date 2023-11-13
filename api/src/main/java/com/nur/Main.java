package com.nur;
import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import com.nur.repositories.*;
import com.nur.repositories.propiedad.PropiedadJpaRepository;
import com.nur.repositories.MetodoPago.MetodoPagoJpaRepository;
import com.nur.repositories.check.in.CheckInJpaRepository;
import com.nur.repositories.persona.PersonaJpaRepository;
import com.nur.repositories.transaccion.TransactionJpaRepository;
import com.nur.repositories.tipoPropiedad.TipoPropiedadJpaRepository;
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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication()
@EnableJpaRepositories(basePackages = { "com.nur.repositories" })
@OpenAPIDefinition(info = @Info(title = "Domain", version = "1.0.0"))
@EntityScan(basePackages = {"com.nur.model"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean(name = "checkInRepository")
    public CheckInRepository checkInRepository() {
        return new CheckInJpaRepository();
    }

    @Bean(name = "passangerRepository")
    public PersonaRepository passangerRepository() {
        return new PersonaJpaRepository();
    }

    @Bean(name = "seatRepository")
    public TransactionRepository seatRepository() {
        return new TransactionJpaRepository();
    }

    @Bean(name = "metodoPagoRepository")
    public MetodoPagoRepository metodoPagoRepository() {
        return new MetodoPagoJpaRepository();
    }


    @Bean(name = "propiedadRepository")
    public PropiedadRepository propiedadRepository() {
        return new PropiedadJpaRepository();
    }

    @Bean(name = "tipoPropiedadRepository")
    public TipoPropiedadRepository tipoPropiedadRepository() {
        return new TipoPropiedadJpaRepository();
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                // System.out.println(beanName);
            }
        };
    }

    @Bean
    Pipeline pipeline(
            ObjectProvider<Command.Handler> commandHandlers,
            ObjectProvider<Notification.Handler> notificationHandlers,
            ObjectProvider<Command.Middleware> middlewares
    ) {
        return new Pipelinr()
                .with(commandHandlers::stream)
                .with(notificationHandlers::stream)
                .with(middlewares::orderedStream);
    }
}
