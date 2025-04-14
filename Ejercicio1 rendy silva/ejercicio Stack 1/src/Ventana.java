import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JTextField txtTexto;
    private JButton btnPush;
    private JButton btnPop;
    private JTextArea txtMostrar;
    private JLabel lblTexto;
    private JButton btnCima;
    private Pila data = new Pila();

    public Ventana() {

        btnPush.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Intentar agregar el elemento a la pila
                    data.push(txtTexto.getText());
                    txtMostrar.setText(data.toString());
                } catch (Exception ex) {
                    // Mostrar un mensaje de error si la pila está llena
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        btnPop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String eliminado = data.pop();
                    JOptionPane.showMessageDialog(null, "Se eliminó: " + eliminado);
                    txtMostrar.setText(data.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        btnCima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cima = data.cima();
                    JOptionPane.showMessageDialog(null, "El elemento de la cima es: " + cima);
                    txtMostrar.setText(data.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

