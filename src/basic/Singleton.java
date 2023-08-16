package basic;

public class Singleton {
    static Singleton instance = new Singleton();

    private Singleton() {
        //
    }
    public Singleton getInstance() {
        return instance;
    }
}
