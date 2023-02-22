package com.example.demo.user.interfaces.todo;

import com.example.demo.user.domain.todo.TodoCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface TodoDtoMapper {
    TodoCommand.AddTodoReq of(TodoDto.AddTodo req);
}
