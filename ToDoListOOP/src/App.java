import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class App {
    public static void main(String[] args) throws Exception {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}

/* Mekanisme penyusunan struktur folder
 * 
 * Logic untuk entity ada di entity layer
 *      entity adalah data yang akan kita simpan, misal todo list, user, dll
 * Logic untuk data ada di repository layer
 *      repository adalah tempat kita menyimpan data, misalnya untuk todo list, kita bisa menyimpan todo list ke dalam array, database, dll
 * Logic untuk bisnis ada di service layer
 *       service adalah tempat kita melakukan bisnis logic, misalnya untuk todo list, kita bisa menambahkan todo list, menghapus todo list, dll
 * Logic untuk view ada di view
 *      view adalah tempat kita menampilkan data, misalnya untuk todo list, kita bisa menampilkan todo list, menambahkan todo list, menghapus todo list, dll
 */