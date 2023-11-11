package rogger.app.hexagonal.application.usecases;

import lombok.AllArgsConstructor;
import rogger.app.hexagonal.domain.models.AdditionalTaskInfo;
import rogger.app.hexagonal.domain.ports.in.GetAdditionalTaskUseCase;
import rogger.app.hexagonal.domain.ports.out.ExternalServicePort;

@AllArgsConstructor
public class GetAddtionalTaskInfoUseImpl implements GetAdditionalTaskUseCase {

    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }

}
