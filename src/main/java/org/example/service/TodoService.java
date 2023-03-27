package org.example.service;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoEntity add(TodoRequest request) {
        TodoEntity entity = TodoEntity.builder()
                .title(request.getTitle())
                .order(request.getOrder())
                .completed(request.getCompleted())
                .build();

        return todoRepository.save(entity);
    }

    public TodoEntity searchById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoEntity> searchAll() {
        return todoRepository.findAll();
    }

    public TodoEntity update(Long id, TodoRequest request) {
        TodoEntity entity = searchById(id);

        if (request.getTitle() != null) {
            entity.setTitle(request.getTitle());
        }

        if (request.getOrder() != null) {
            entity.setOrder(request.getOrder());
        }

        if (request.getCompleted() != null) {
            entity.setCompleted(request.getCompleted());
        }

        return todoRepository.save(entity);
    }

    public void deleteById(Long id) {

    }

    public void deleteAll() {

    }
}
