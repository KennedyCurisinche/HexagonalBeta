package rogger.app.hexagonal.application.usecases;

import lombok.AllArgsConstructor;
import rogger.app.hexagonal.domain.models.Task;
import rogger.app.hexagonal.domain.ports.in.RetrieveTaskUseCase;
import rogger.app.hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
