import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

public class Mesa {
    private String[] ingredientes;

    public Mesa(){
        ingredientes=null;
    }

    public String[] tomarIngredientes(){
        return ingredientes;
    }

    public void cargarIngredientes(){
        ingredientes=this.generarIngredientes();
    }

    private String[] generarIngredientes(){
        Random random = new Random();
        String i1=null;
        String i2=null;
        boolean b=true;
        while(b) {
            int n1 = random.nextInt(3);
            int n2 = random.nextInt(3);
            i1=this.getIngrediente(n1);
            i2=this.getIngrediente(n2);
            if(n1!=n2 && i1!=null && i2!=null){
                b=false;
            }
        }
        return new String[]{i1, i2};
    }

    private String getIngrediente(int i){
        switch (i){
            case 0:
                return "tabaco";
            case 1:
                return "papel";
            case 2:
                return "fosforo";
            default:
                return null;
        }
    }

    public int estadoMesa(){

        if (ingredientes!=null){
            if(this.buscarIngrediente("tabaco") && this.buscarIngrediente("fosforo")){
                return 1;
            }
            if(this.buscarIngrediente("papel") && this.buscarIngrediente("fosforo")){
                return 2;
            }
            if(this.buscarIngrediente("papel") && this.buscarIngrediente("tabaco")){
                return 3;
            }

        }
        return 0;
    }

    private boolean buscarIngrediente(String ing){
        if(ingredientes[0]==ing || ingredientes[1]==ing){
            return true;
        }
        return false;
    }


}
