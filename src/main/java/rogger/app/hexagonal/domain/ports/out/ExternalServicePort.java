package rogger.app.hexagonal.domain.ports.out;

import rogger.app.hexagonal.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {

    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);

}
