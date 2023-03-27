package org.example.service;

import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Mock 사용을 위한 어노테이션
class TodoServiceTest {
    @Mock
    private TodoRepository todoRepository;

    @InjectMocks // mock 주입을 받아서 사용함
    private TodoService todoService;

    // Mock을 사용하는 이유
    // 1. 외부 시스템에 의존하지않고 자체 테스트를 할 수 있어야하기 때문에 목을 사용
    // 2. Unit Test 네트워크나 데이터베이스가 안 된다고 해도 가능해야하기 때문에 Mock을 사용합니다.
    // 3. 테스트를 진행하는데 있어서 서비스 운영 데이터베이스에 영향을 주면 안 되기 때문에 사용

    @Test
    void add() {
        when(todoRepository.save(any(TodoEntity.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        TodoRequest expected = new TodoRequest();
        expected.setTitle("TEST TITLE");

        TodoEntity actual = todoService.add(expected);

        assertEquals(expected.getTitle(), actual.getTitle());
    }

    @Test
    void searchById() {
    }
}