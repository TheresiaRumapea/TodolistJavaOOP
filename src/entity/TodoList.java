package entity;

public class TodoList {
    //Entity, Model, class yang representase data biasanya memakai ENKAPSULASI pada atributnya sehingga butuh SETTER GETTER serta buat CONSTRUCTOR
    private String todo;

    public TodoList(){
    }

    public TodoList(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
