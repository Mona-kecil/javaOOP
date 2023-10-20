package view;

import entity.TodoList;
import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while(true) {
            todoListService.showTodoList();

            System.out.println("Menu: ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");

            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodoList() {
        System.out.println("Menambahkan Todo List");

        var todo = InputUtil.input("Todo (x Jika Batal)");
        if (todo.equals("x")) {
            return;
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("Menghapus Todo List");

        var index = InputUtil.input("Nomor yang Dihapus (x Jika Batal)");
        if (index.equals("x")) {
            return;
        } else {
            todoListService.removeTodoList(Integer.valueOf(index));
        }
    }
}