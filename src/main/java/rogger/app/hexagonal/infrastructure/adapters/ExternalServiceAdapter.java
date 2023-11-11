package rogger.app.hexagonal.infrastructure.adapters;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import rogger.app.hexagonal.domain.models.AdditionalTaskInfo;
import rogger.app.hexagonal.domain.ports.out.ExternalServicePort;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {

        String apiURL = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiURL, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();

        if (todo == null) {
            return null;
        }

        apiURL = "https://jsonplaceholder.typicode.com/users/" + todo.getId();
        ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(apiURL, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = userResponse.getBody();

        if (user == null) {
            return null;
        }

        return new AdditionalTaskInfo(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

    }

    @Data
    private static class JsonPlaceHolderTodo {

        private Long id;
        private Long userId;

    }

    @Data
    private static class JsonPlaceHolderUser {

        private Long id;
        private String name;
        private String email;

    }

}
