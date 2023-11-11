package rogger.app.hexagonal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
@AllArgsConstructor
public class AdditionalTaskInfo {

    private final Long userId;
    private final String userName;
    private final String userEmail;

}
