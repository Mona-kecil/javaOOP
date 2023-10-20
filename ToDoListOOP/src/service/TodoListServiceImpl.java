package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {
    
    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();
        System.out.println("Show To Do List");

        for (int i = 0; i < model.length; i++)
        {
            var todo = model[i];
            if (todo != null)
                System.out.println((i + 1) + ". " + todo.getTodo());
        }
    }

    public void addTodoList(String todo) {
        TodoList todolist = new TodoList(todo);
        todoListRepository.add(todolist);
        System.out.println("Sukses menambahkan todo: " + todo);
    }

    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success)
            System.out.println("Sukses menghapus todo: " + number);
        else
            System.out.println("Gagal menghapus todo: " + number + " tidak ditemukan");
    }
}
