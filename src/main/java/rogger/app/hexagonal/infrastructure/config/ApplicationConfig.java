package rogger.app.hexagonal.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rogger.app.hexagonal.application.services.TaskService;
import rogger.app.hexagonal.application.usecases.CreateTaskUseCaseImpl;
import rogger.app.hexagonal.application.usecases.DeleteTaskUseCaseImpl;
import rogger.app.hexagonal.application.usecases.GetAddtionalTaskInfoUseImpl;
import rogger.app.hexagonal.application.usecases.RetrieveTaskUseCaseImpl;
import rogger.app.hexagonal.application.usecases.UpdateTaskUseCaseImpl;
import rogger.app.hexagonal.domain.ports.in.GetAdditionalTaskUseCase;
import rogger.app.hexagonal.domain.ports.out.ExternalServicePort;
import rogger.app.hexagonal.domain.ports.out.TaskRepositoryPort;
import rogger.app.hexagonal.infrastructure.adapters.ExternalServiceAdapter;
import rogger.app.hexagonal.infrastructure.repositories.JpaTaskRepositoryAdapter;

@Configuration
public class ApplicationConfig {

    @Bean
    TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskUseCase getAdditionalTaskUseCase) {

        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskUseCase
        );

    }

    @Bean
    TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    GetAdditionalTaskUseCase getAdditionalTaskUseCase(ExternalServicePort externalServicePort) {
        return new GetAddtionalTaskInfoUseImpl(externalServicePort);
    }

    @Bean
    ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }


}
