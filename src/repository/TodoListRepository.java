package repository;

import entity.TodoList;

public interface TodoListRepository {

    TodoList[] getAll();
    //biasanya dlm repository nama perintah fungsinya seperti GET, FIND
    //lebih ke perintah MENGAMBIL DATA
    //bukan SHOW

    void add(TodoList todoList);

    boolean remove(Integer number);

}
