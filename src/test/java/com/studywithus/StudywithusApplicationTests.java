package com.studywithus;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootTest
class StudywithusApplicationTests {
	@Bean
	Hibernate5Module hibernate5Module() {
		Hibernate5Module hibernate5Module = new Hibernate5Module();
//        hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
		return hibernate5Module;
	}

	@Bean
	public AuditorAware<String> auditorProvider(){
		return () -> Optional.of(UUID.randomUUID().toString());
	}

}
