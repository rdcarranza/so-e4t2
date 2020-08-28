import java.util.concurrent.Semaphore;

public class Ejercicio4 {
    private static Mesa mesa;
    private static Semaphore semaforo;
    private static Semaphore semaforo1;
    private static Semaphore semaforo2;
    private static Semaphore semaforo3;

    public static void main(String[] args) {
        mesa=new Mesa();
        semaforo=new Semaphore(1);
        semaforo1=new Semaphore(0);
        semaforo2=new Semaphore(0);
        semaforo3=new Semaphore(0);

        Proveedor proveedor=new Proveedor(mesa,semaforo,semaforo1,semaforo2,semaforo3);
        Fumador fumador1 = new Fumador("papel",mesa,semaforo,semaforo1);
        Fumador fumador2 = new Fumador("tabaco",mesa,semaforo,semaforo2);
        Fumador fumador3 = new Fumador("fosforo",mesa,semaforo,semaforo3);

        proveedor.start();
        fumador1.start();
        fumador2.start();
        fumador3.start();

    }
}
