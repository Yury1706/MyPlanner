package domain;

public class GenTasks<T> {

    private T obj;

    public GenTasks() {
    }

    public GenTasks(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
