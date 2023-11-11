package rogger.app.hexagonal.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rogger.app.hexagonal.domain.models.Task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private Boolean completed;

    //Aca se realiza el mapper - Por ahora static
    public static TaskEntity fromDomainModel(Task task) {

        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.getCompleted()
        );

    }

    public Task toDomainModel() {

        return new Task(
                id,
                title,
                description,
                creationDate,
                completed
        );

    }

}
