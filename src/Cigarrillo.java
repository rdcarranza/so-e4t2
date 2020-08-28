public class Cigarrillo {
    boolean estado; //false - desarmado, true - armado
    String ing1;
    String ing2;
    String ing3;

    public Cigarrillo(String ing){
        ing1=ing;
        ing2=null;
        ing3=null;
        estado=false;
    }

    public void armar(String[] ings){
        if (ings!=null) {
            ing2 = ings[0];
            ing3 = ings[1];
            if (ing1 != ing2 && ing1 != ing3) {
                estado = true;
                System.out.println("El cigarrillo fue armado exitosamente!");
            } else {
                estado = false;
                System.out.println("El cigarrillo NO pudo ser armado.");
            }
        }
    }

    public boolean fumar(){
        if (estado){
            System.out.println("El fumador del "+ing1+", está fumando!");
        }else{
            System.out.println("El fumador del "+ing1+", NO puede fumar sin el cigarrillo!");
        }
        return estado;
    }

}
