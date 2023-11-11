package rogger.app.hexagonal.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rogger.app.hexagonal.infrastructure.entities.TaskEntity;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
