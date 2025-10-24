package it.sts.stscasostudiocrud;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StscasostudiocrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StscasostudiocrudApplication.class, args);
	}

	@Bean
	public ModelMapper istanceModelMapper() {
		ModelMapper mapper = new ModelMapper();
		return mapper;
	}

}
