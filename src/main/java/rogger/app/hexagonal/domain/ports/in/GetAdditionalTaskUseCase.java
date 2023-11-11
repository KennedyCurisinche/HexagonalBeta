package rogger.app.hexagonal.domain.ports.in;

import rogger.app.hexagonal.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskUseCase {

    AdditionalTaskInfo getAdditionalTaskInfo(Long id);

}
