package rogger.app.hexagonal.domain.ports.out;

import rogger.app.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {

    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    Optional<Task> update(Task task);
    Boolean deleteById(Long id);

}
