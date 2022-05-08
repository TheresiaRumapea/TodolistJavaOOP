package view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        label:
        while (true){
            todoListService.showTodoList();

            //menerima input
            System.out.println("==MENU==");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");

            switch (input) {
                case "1":
                    addTodoList();
                    break;
                case "2":
                    removeTodoList();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Pilihan tidak dimengerti");
            }
        }
    }
    public void addTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = InputUtil.input("Todo (x Jika Batal)");

        if(todo.equals("x")){
            //batal
        } else{
            todoListService.addTodoList(todo);
        }
    }
    public void removeTodoList(){

        System.out.println("MENGHAPUS TODO LIST");

        var number = InputUtil.input("Nomor yang dihapus (x Jika Batal )");

        if(number.equals("x")){
            //batal
        } else{
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}
