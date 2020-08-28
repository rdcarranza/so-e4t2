import java.util.concurrent.Semaphore;

public class Fumador extends Thread{
    private Mesa mesa;
    private String ingrediente;
    private Semaphore semaforo;
    private Semaphore semaforoI;
    private Cigarrillo cigarro;

    public Fumador(String ing, Mesa m, Semaphore s, Semaphore si){
        ingrediente=ing;
        mesa=m;
        semaforo=s;
        semaforoI=si;
        cigarro=new Cigarrillo(ingrediente);
    }

    @Override
    public void run() {
        super.run();
        while(true){
            try {
                semaforoI.acquire(); //espera
                semaforo.acquire(); //espera
                String[] ingredientes=mesa.tomarIngredientes();
                cigarro.armar(ingredientes);
                if(cigarro.fumar()){
                    semaforo.release();//señal
                    Thread.sleep(1000);
                }else{
                    semaforo.release();//señal
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
