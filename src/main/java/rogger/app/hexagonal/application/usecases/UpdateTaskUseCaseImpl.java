package rogger.app.hexagonal.application.usecases;

import lombok.AllArgsConstructor;
import rogger.app.hexagonal.domain.models.Task;
import rogger.app.hexagonal.domain.ports.in.UpdateTaskUseCase;
import rogger.app.hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

@AllArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }

}
