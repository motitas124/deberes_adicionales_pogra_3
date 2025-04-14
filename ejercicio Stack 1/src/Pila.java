import  java.util.Stack;
public class Pila {
    private Stack<String> coleccion;

  public Pila(){
      coleccion=new Stack<String>();
  }
  public void push(String dato){
      coleccion.push(dato);
  }
  public String pop() throws Exception{
      if(coleccion.empty())
          throw new Exception("Error en metodo Pop, pila vacia");
      return coleccion.pop();
  }

  public  String cima()throws Exception{
      if (coleccion.empty())
          throw new Exception("Erros en metodo Push, Pila vacia");
      return coleccion.peek();
  }

    @Override
    public String toString() {
      StringBuilder listado=new StringBuilder();
        for (int i=coleccion.size()-1;i>=0;i--){
            listado.append(coleccion.get(i)+"\n");
        }
        return listado.toString();
    }

}
