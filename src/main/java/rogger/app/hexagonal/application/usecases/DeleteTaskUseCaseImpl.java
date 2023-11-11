package rogger.app.hexagonal.application.usecases;

import lombok.AllArgsConstructor;
import rogger.app.hexagonal.domain.ports.in.DeleteTaskUseCase;
import rogger.app.hexagonal.domain.ports.out.TaskRepositoryPort;

@AllArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }

}
