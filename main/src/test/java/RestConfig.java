// import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Data
public class RestConfig {

    // Base URL
    @Value("${test.rest.service.host}")
    private String baseUrl;

    // Get User
    @Value("${test.rest.service.endpoints.get.users}")
    private String getUserEndpoint;

    // Post Users
    @Value("${test.rest.service.endpoints.post.users}")
    private String postUserEndpoint;

    // User schema
    @Value("${test.rest.service.schema.users-list}")
    private String userListResponseSchema;

}


