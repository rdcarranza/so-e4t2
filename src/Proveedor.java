import java.util.concurrent.Semaphore;

public class Proveedor extends Thread{
    private Mesa mesa;
    private String[] ingredientes;
    private Semaphore semaforo;
    private Semaphore semaforo1;
    private Semaphore semaforo2;
    private Semaphore semaforo3;

    public Proveedor(Mesa m,Semaphore s, Semaphore s1, Semaphore s2, Semaphore s3 ){
        mesa=m;
        ingredientes=null;
        semaforo=s;
        semaforo1=s1;
        semaforo2=s2;
        semaforo3=s3;
    }//fin constructor.

    @Override
    public void run() {
        super.run();
        while(true){
            try {
                semaforo.acquire();
                mesa.cargarIngredientes();
                switch (mesa.estadoMesa()){
                    case 1:
                        System.out.println("El proveedor pone en la mesa: TABACO Y FOSFORO.");
                        semaforo1.release();
                        break;
                    case 2:
                        System.out.println("El proveedor pone en la mesa: PAPEL Y FOSFORO.");
                        semaforo2.release();
                        break;
                    case 3:
                        System.out.println("El proveedor pone en la mesa: PAPEL Y TABACO.");
                        semaforo3.release();
                        break;
                    default:
                        break;
                }
                semaforo.release();
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }//fin run.

}//FIN CLASE.
