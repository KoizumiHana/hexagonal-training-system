package com.hexagonal.training.application.web;

import com.hexagonal.training.application.web.mapper.ApplicationTrainingMapper;
import com.hexagonal.training.application.web.request.AddLessonRequest;
import com.hexagonal.training.application.web.request.AssignTraineeRequest;
import com.hexagonal.training.application.web.response.TrainingResponse;
import com.hexagonal.training.domain.model.AddLessonCommand;
import com.hexagonal.training.domain.model.AssignTraineeCommand;
import com.hexagonal.training.domain.model.CreateTrainingCommand;
import com.hexagonal.training.domain.ports.incoming.AddLessonUseCase;
import com.hexagonal.training.domain.ports.incoming.AssignTraineeUseCase;
import com.hexagonal.training.domain.ports.incoming.CreateTrainingUseCase;
import com.hexagonal.training.domain.ports.incoming.FindTrainingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {

    private final CreateTrainingUseCase createTrainingUseCase;
    private final FindTrainingUseCase findTrainingUseCase;
    private final AddLessonUseCase addLessonUseCase;
    private final AssignTraineeUseCase assignTraineeUseCase;

    @PostMapping("/")
    @ResponseStatus(CREATED)
    public TrainingResponse createTraining(@RequestBody CreateTrainingCommand createTrainingCommand) {
        return ApplicationTrainingMapper.businessEntityToResponse(createTrainingUseCase.handle(createTrainingCommand));
    }

    @GetMapping("/{id}")
    public TrainingResponse findById(@PathVariable Long id) {
        return ApplicationTrainingMapper.businessEntityToResponse(findTrainingUseCase.byId(id));
    }

    @GetMapping("/")
    public List<TrainingResponse> findAll() {
        return findTrainingUseCase.all().stream().map(ApplicationTrainingMapper::businessEntityToResponse).toList();
    }

    @PostMapping("/{id}/lesson")
    @ResponseStatus(CREATED)
    public void addLesson(@PathVariable Long id,
                          @RequestBody AddLessonRequest addLessonCommand) {
        addLessonUseCase.handle(AddLessonCommand.builder()
                .trainingId(id)
                .topicName(addLessonCommand.getTopicName())
                .lessonTime(addLessonCommand.getLessonTime())
                .build());
    }

    @ResponseStatus(CREATED)
    @PostMapping("/{id}/trainee")
    public void assignTrainee(@PathVariable Long id,
                              @RequestBody AssignTraineeRequest assignTraineeRequest) {
        assignTraineeUseCase.handle(AssignTraineeCommand.builder()
                .firstname(assignTraineeRequest.getFirstname())
                .lastname(assignTraineeRequest.getLastname())
                .surname(assignTraineeRequest.getSurname())
                .email(assignTraineeRequest.getEmail())
                .trainingId(id)
                .build());
    }
}
