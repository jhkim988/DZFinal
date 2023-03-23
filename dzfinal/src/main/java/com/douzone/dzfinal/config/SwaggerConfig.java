package com.douzone.dzfinal.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

    private final String version = "V1";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("dzfinal API")
                .description("Swagger 소개!!")
                .build();
    }

    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(version)
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.douzone.dzfinal"))
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.any())
                .build();
    }
    
    @Bean
    public Docket commonApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("V2")
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.douzone.dzfinal"))
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.any())
                .build();
    }
}


//@Configuration	// 스프링 실행시 설정파일 읽어드리기 위한 어노테이션 
//@EnableSwagger2	// Swagger2를 사용하겠다는 어노테이션 
//@SuppressWarnings("unchecked")	// warning밑줄 제거를 위한 태그 
//public class SwaggerConfig extends WebMvcConfigurationSupport {
//
//	//리소스 핸들러 설
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}
//
//
//    // API마다 구분짓기 위한 설정.
//	@Bean
//    public Docket productApi() {
//        return getDocket("유저", Predicates.or(
//                PathSelectors.regex("/user.*")));
//    }
//
//    
//    @Bean
//    public Docket searchApi() {
//        return getDocket("예약", Predicates.or(
//                PathSelectors.regex("/reservation.*")));
//    }
//
//    
//    @Bean
//    public Docket commonApi() {
//        return getDocket("공통", Predicates.or(
//                PathSelectors.regex("/test.*")));
//        		
//    }
//
//    @Bean
//    public Docket allApi() {
//        return getDocket("전체", Predicates.or(
//                PathSelectors.regex("/*.*")));
//    }
//    
//    //swagger 설정.
//    public Docket getDocket(String groupName, Predicate<String> predicate) {
//        return new Docket(DocumentationType.SWAGGER_2)
//        		.groupName(groupName)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.douzone.dzfinal"))
//                .paths(PathSelectors.ant("/V1/**"))
//                .apis(RequestHandlerSelectors.any())
//                .build();
//    }
//    
//    //swagger ui 설정.
//    @Bean
//    public UiConfiguration uiConfig() {
//        return UiConfigurationBuilder.builder()
//                .displayRequestDuration(true)
//                .validatorUrl("")
//                .build();
//    }
//
//		private List<ResponseMessage> getCustomizedResponseMessages() {
//		    List<ResponseMessage> responseMessages = new ArrayList<>();
//		    responseMessages.add(new ResponseMessageBuilder().code(200).message("성공").build());
//		    responseMessages.add(new ResponseMessageBuilder().code(204).message("데이터 미존재").build());
//		    responseMessages.add(new ResponseMessageBuilder().code(400).message("입력값 오류").build());
//		    responseMessages.add(new ResponseMessageBuilder().code(401).message("미 로그인").build());
//		    responseMessages.add(new ResponseMessageBuilder().code(403).message("권한없음").build());
//		    responseMessages.add(new ResponseMessageBuilder().code(412).message("처리중 오류").build());
//		    responseMessages.add(new ResponseMessageBuilder().code(500).message("서버에러").build());
//		    return responseMessages;
//		}
//	
//}




// 혜지언
//@Configuration
//@EnableSwagger2
//@EnableWebMvc
//public class SwaggerConfig {
//	private String version;
//  private String title;
//  private final String TITLE_FIX = "DZ project 04 API";
//	
//  @Bean
//  Docket apiV1() {
//      version = "V1";
//      title = TITLE_FIX + version;
//
//      return new Docket(DocumentationType.SWAGGER_2)
//              .useDefaultResponseMessages(false)
//              .select()
//              .apis(RequestHandlerSelectors.basePackage("com.douzone.dzfinal"))
//              .paths(PathSelectors.ant("/V1/**"))
//              .build()
//              .apiInfo(getApiInfo(title, version))
//              .securitySchemes(Collections.singletonList(getApiKey()))
//              .enable(true);
//  }
//	
//	private ApiInfo getApiInfo(String title, String version) {
//      return new ApiInfo(
//              title,
//              "Swagger API Docs",
//              version,
//              "com.douzone.dzfinal",
//              new Contact("dzfinal", "com.douzone", "skdlfxp135@naver.com"),
//              "Licenses",
//              "com.douzone.dzfinal",
//              new ArrayList<>()
//      );
//  }
//
//  private ApiKey getApiKey () {
//      return new ApiKey("jwtToken", "X-AUTH-TOKEN", "header");
//  }
//  
//  private List<ResponseMessage> getCustomizedResponseMessages() {
//      List<ResponseMessage> responseMessages = new ArrayList<>();
//      responseMessages.add(new ResponseMessageBuilder().code(200).message("성공").build());
//      responseMessages.add(new ResponseMessageBuilder().code(204).message("데이터 미존재").build());
//      responseMessages.add(new ResponseMessageBuilder().code(400).message("입력값 오류").build());
//      responseMessages.add(new ResponseMessageBuilder().code(401).message("미 로그인").build());
//      responseMessages.add(new ResponseMessageBuilder().code(403).message("권한없음").build());
//      responseMessages.add(new ResponseMessageBuilder().code(412).message("처리중 오류").build());
//      responseMessages.add(new ResponseMessageBuilder().code(500).message("서버에러").build());
//      return responseMessages;
//  }
//}