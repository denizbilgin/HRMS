package HRMS.HRMS;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(HrmsApplication.class, args);
	}

	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("HRMS.HRMS"))
				.build();
	}

	@Bean
	public Cloudinary cloudinaryService()
	{
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dy9qtbhqc",
				"api_key", "458658496897112",
				"api_secret", "HFvI_aLKtWA5lc6XipJqoLrOqGI"));
	}
	
	@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

}
