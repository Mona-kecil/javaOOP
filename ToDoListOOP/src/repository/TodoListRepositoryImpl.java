package repository;

import java.util.Arrays;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {
    
    public TodoList[] data = new TodoList[10];

    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    public void resizeIfFull() {
        if (isFull()) {
            var temp = data;
            data = new TodoList[data.length + data.length / 2];
    
            data = Arrays.copyOf(temp, data.length);
        }
    }

    public void add(TodoList todolist) {
        resizeIfFull();

        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    public boolean remove(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number-1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++)
            {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i+1];
                }
            }
            return true;
        }
    }
}
