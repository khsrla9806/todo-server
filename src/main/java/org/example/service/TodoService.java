package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.TodoModel;
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

    public TodoModel add(TodoRequest request) {
        TodoModel entity = TodoModel.builder()
                .title(request.getTitle())
                .order(request.getOrder())
                .completed(request.getCompleted())
                .build();

        return todoRepository.save(entity);
    }

    public TodoModel searchById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoModel> searchAll() {
        return todoRepository.findAll();
    }

    public TodoModel update(Long id, TodoRequest request) {
        TodoModel entity = searchById(id);

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
        todoRepository.deleteById(id);
    }

    public void deleteAll() {
        todoRepository.deleteAll();
    }
}
