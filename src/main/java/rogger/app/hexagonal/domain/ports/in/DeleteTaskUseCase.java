package rogger.app.hexagonal.domain.ports.in;

public interface DeleteTaskUseCase {

    Boolean deleteTask(Long id);

}
