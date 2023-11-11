package rogger.app.hexagonal.application.services;

import lombok.AllArgsConstructor;
import rogger.app.hexagonal.domain.models.AdditionalTaskInfo;
import rogger.app.hexagonal.domain.models.Task;
import rogger.app.hexagonal.domain.ports.in.CreateTaskUseCase;
import rogger.app.hexagonal.domain.ports.in.DeleteTaskUseCase;
import rogger.app.hexagonal.domain.ports.in.GetAdditionalTaskUseCase;
import rogger.app.hexagonal.domain.ports.in.RetrieveTaskUseCase;
import rogger.app.hexagonal.domain.ports.in.UpdateTaskUseCase;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class TaskService implements CreateTaskUseCase,
        RetrieveTaskUseCase, UpdateTaskUseCase,
        DeleteTaskUseCase, GetAdditionalTaskUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskUseCase getAdditionalTaskUseCase;

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return updateTaskUseCase.updateTask(id, updateTask);
    }

    @Override
    public Boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

}
