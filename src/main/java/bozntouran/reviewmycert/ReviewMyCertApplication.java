package bozntouran.reviewmyert;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "ReviewMyCert API",
				version = "1.0"
		)
)
@SpringBootApplication
public class ReviewMyCertApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewMyCertApplication.class, args);
	}

}
