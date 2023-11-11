package rogger.app.hexagonal.application.usecases;

import lombok.AllArgsConstructor;
import rogger.app.hexagonal.domain.models.Task;
import rogger.app.hexagonal.domain.ports.in.CreateTaskUseCase;
import rogger.app.hexagonal.domain.ports.out.TaskRepositoryPort;

@AllArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }

}
