package rogger.app.hexagonal.domain.ports.in;

import rogger.app.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {

    Optional<Task> getTask(Long id);
    List<Task> getAllTasks();

}
