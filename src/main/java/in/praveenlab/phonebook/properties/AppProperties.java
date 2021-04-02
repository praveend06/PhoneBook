package in.praveenlab.phonebook.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "phonebook")
@Component
public class AppProperties {
	
	Map<String, String> messages = new HashMap<>();

}
