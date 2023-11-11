package rogger.app.hexagonal.domain.ports.in;

import rogger.app.hexagonal.domain.models.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);

}
