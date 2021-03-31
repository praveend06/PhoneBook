package in.praveenlab.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import in.praveenlab.phonebook.entity.Contact;
import in.praveenlab.phonebook.repository.ContactRepository;

@SpringBootApplication
public class PhoneBookApplication{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PhoneBookApplication.class, args);

	}

}
