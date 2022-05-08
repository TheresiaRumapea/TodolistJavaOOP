package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList(){
    //model[0] = "Belajar Java Dasar";
    //model[1] = "Senang untuk belajar java";
    //showTodoList();

        //Mau manipulasi data dengan membuat inisialisasi data baru, DATA -> Repository
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Belajar Java Dasar");
        todoListRepository.data[1] = new TodoList("Belajar Java OOP");
        todoListRepository.data[2] = new TodoList("Belajar Java Standard Classes");

        //Mau memanggil fungsi  showTodoList, BISNIS LOGIC -> Service
        TodoListServiceImpl todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.showTodoList();

    }

    public static void testAddTodoList(){
        //Awalnya seperti ini di TodoList javadasar
        //  for(int i=0; i < 25; i++){
        //    addTodoList("Contoh Todo Ke. " + i);
        //  }
        //  showTodoList();

        //Buat objek agar Data yang dipakai oleh SERVICE berasal dari REPOSITORY
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        //Buat objek agar dapat menggunakan fungsi yang ada di SERVICE yaitu "todoListService"
        //Kemudian pakai "todolIstRepository" sebagai PARAMETER
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar java dasar");
        todoListService.addTodoList("Belajar java OOP");
        todoListService.addTodoList("Belajar java Standard Classes");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
//        addTodoList("Satu");
//        addTodoList("Dua");
//        addTodoList("Tiga");
//
//        //Test dengan indek number > array.length : FALSE
//        var result = removeTodoList(20);
//        System.out.println(result);
//        //Test dengan indeks number yang isi arraynya null
//        //karena isi array saat ini hanya ada 3 yaitu Satu, Dua, Tiga
//        result = removeTodoList(4);
//        System.out.println(result);
//        //Test dengan indeks number yang isi arraynya ada di list
//        result = removeTodoList(2);
//        System.out.println(result);
//
//        showTodoList();

            TodoListRepository todoListRepository = new TodoListRepositoryImpl();

            TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

            todoListService.addTodoList("Belajar Java Dasar");
            todoListService.addTodoList("Belajar Java OOP");
            todoListService.addTodoList("Belajar Java Standard Classes");

            todoListService.showTodoList();

            todoListService.removeTodoList(5);
            todoListService.showTodoList();

            todoListService.removeTodoList(2);
            todoListService.showTodoList();
    }

}
