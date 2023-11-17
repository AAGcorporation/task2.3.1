package ru.goryunov.pptask6.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
// настройка конфигурации
@Configuration //класс является конфигурационным
@EnableWebMvc // позволяет импортировать конфигурацию Spring MVC из класса WebMvcConfigurationSupport
// WebMvcConfigurer - сжатая аналогия этого интерфейса, который на след. этапе нужно будет реализовать.
@ComponentScan(basePackages = "ru.goryunov.pptask6")  //  искать компоненты, @Component, @Controller,@Repository,@Service.
public class WebConfig {

    @Bean //Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver; //интерфейс, необходимый для нахождения представления по имени.
    }
}
