import javax.swing.*;

public class Principal {
    public static void main(String[] args) throws Exception {
        Pila data=new Pila();
        data.push("Elemento 1");
        data.push("Elemento 2");
        data.push("Elemento 3");
        data.push("Elemento 4");
        data.push("Elemento 5");
        System.out.println("Pila");
        System.out.println(data.toString());
        String eliminado= null;
        try {
            eliminado = data.pop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(null,eliminado);
        System.out.println("Pila");
        System.out.println(data.toString());
        JOptionPane.showMessageDialog(null,"En la cima de la pila: "+data.cima());
    }
}
