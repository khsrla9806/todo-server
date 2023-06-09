package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    public TodoResponse(TodoModel entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.order = entity.getOrder();
        this.completed = entity.getCompleted();
        this.url = "http://localhost:8080/" + this.id;
    }
}
