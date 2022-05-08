package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    //akses DATA ITU HARUS DARI REPOSITORY, yaitu dengan cara deklarasi
    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        //Kita ambil semua MODEL yang akan DIPAKAI dari REPOSITORY
        TodoList[] model = todoListRepository.getAll();

            //Butuh index di number jadi tidak bisa pake for each
        System.out.println("TODO LIST");
        for(var i = 0; i< model.length; i++){
            var todolist = model[i];
            //number = number to do list
            var no = i+1;

            //jangan menambahkan array yang data kosong
            if(todolist != null){
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("SUKSES MENAMBAH TODO : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);

        if(success){
            System.out.println("BERHASIL MENGHAPUS TODO " + number);
        }
        else{
            System.out.println("GAGAL MENGHAPUS TODO " + number);
        }
    }
}
