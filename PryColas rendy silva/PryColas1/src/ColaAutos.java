import java.util.LinkedList;
import java.util.Queue;

public class ColaAutos {
    private Queue<Auto> listaAutos;

    public ColaAutos() {
        listaAutos=new LinkedList<Auto>();
    }

    public void encolar(Auto dato){
        listaAutos.add(dato);

    }

    public Auto desencolar()throws Exception{
        if (listaAutos.isEmpty())
            throw new Exception("Ya no existen Autos encolados, valores pendientes pagados.");
        return listaAutos.poll();
    }

    public Auto frente()throws Exception{
        if (listaAutos.isEmpty())
            throw new Exception("Ya no existen Autos encolados");
        return listaAutos.peek();
    }

    public String listarTodos(){
        StringBuilder sb=new StringBuilder();
        for (Auto a1:listaAutos){
            sb.append(a1.toString());

        }
        return sb.toString();

    }

}
