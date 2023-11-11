package rogger.app.hexagonal.domain.ports.in;

import rogger.app.hexagonal.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {

    Optional<Task> updateTask(Long id, Task updateTask);

}
