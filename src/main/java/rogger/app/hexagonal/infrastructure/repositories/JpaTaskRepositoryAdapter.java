package rogger.app.hexagonal.infrastructure.repositories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import rogger.app.hexagonal.domain.models.Task;
import rogger.app.hexagonal.domain.ports.out.TaskRepositoryPort;
import rogger.app.hexagonal.infrastructure.entities.TaskEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    @Override
    public Task save(Task task) {

        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity saveEntity = jpaTaskRepository.save(taskEntity);
        return saveEntity.toDomainModel();

    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {

        return jpaTaskRepository.findAll().stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Task> update(Task task) {

        if (jpaTaskRepository.existsById(task.getId())) {

            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity updateTaskEntity = jpaTaskRepository.saveAndFlush(taskEntity);
            return Optional.of(updateTaskEntity.toDomainModel());

        }

        return Optional.empty();

    }

    @Override
    public Boolean deleteById(Long id) {

        if (jpaTaskRepository.existsById(id)) {
            jpaTaskRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
