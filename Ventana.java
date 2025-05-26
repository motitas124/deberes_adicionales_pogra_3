import javax.swing.*;
import java.awt.event.*;

public class Ventana extends javax.swing.JFrame {
    RegistroMotocicletas registro = new RegistroMotocicletas();

    public Ventana() {
        initComponents();
        mostrarMotocicletas();
    }

    private void mostrarMotocicletas() {
        txtResultado.setText("");
        for (Motocicleta m : registro.getLista()) {
            txtResultado.append(m.toString() + "\n");
        }
    }

    private void btnAgregarActionPerformed(ActionEvent evt) {
        try {
            String marca = txtMarcaIngreso.getText();
            int cc = Integer.parseInt(txtCilindrajeIng.getText());
            double precio = Double.parseDouble(txtPrecioIngreso.getText());
            String color = comboColorIngreso.getSelectedItem().toString();

            if (precio < 1500 || precio > 30000) {
                JOptionPane.showMessageDialog(this, "Precio debe ser entre 1500 y 30000.");
                return;
            }

            Motocicleta moto = new Motocicleta(marca, cc, precio, color);
            registro.agregar(moto);
            JOptionPane.showMessageDialog(this, "Motocicleta agregada.");
            mostrarMotocicletas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos.");
        }
    }

    private void btnActualizarActionPerformed(ActionEvent evt) {
        try {
            String marca = txtMarcaActualizar.getText();
            int cc = Integer.parseInt(txtCilindrajeActualizar.getText());
            double precio = Double.parseDouble(txtPrecioActualizar.getText());
            String color = comboColorActualizar.getSelectedItem().toString();

            if (precio < 1500 || precio > 30000) {
                JOptionPane.showMessageDialog(this, "Precio debe ser entre 1500 y 30000.");
                return;
            }

            Motocicleta moto = registro.buscarPorMarca(marca);
            if (moto != null) {
                registro.actualizar(marca, cc, precio, color);
                JOptionPane.showMessageDialog(this, "Motocicleta actualizada.");
                mostrarMotocicletas();
            } else {
                JOptionPane.showMessageDialog(this, "Motocicleta no encontrada.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos.");
        }
    }

    private void btnBuscarActionPerformed(ActionEvent evt) {
        String marca = txtBuscarMarca.getText();
        Motocicleta moto = registro.buscarPorMarca(marca);
        if (moto != null) {
            txtResultado.setText("Encontrada: " + moto.toString());
        } else {
            txtResultado.setText("Motocicleta no encontrada.");
        }
    }

    private void btnOrdenarActionPerformed(ActionEvent evt) {
        registro.ordenarPorPrecio();
        mostrarMotocicletas();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Ventana().setVisible(true));
    }
}