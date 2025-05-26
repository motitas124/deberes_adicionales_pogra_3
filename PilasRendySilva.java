
// ProyectoMotocicletasCompleto.java
// Incluye: Motocicleta, RegistroMotocicletas, Ventana

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Clase Motocicleta
class Motocicleta {
    private String marca;
    private int cilindraje;
    private double precio;
    private String color;

    public Motocicleta(String marca, int cilindraje, double precio, String color) {
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.precio = precio;
        this.color = color;
    }

    public String getMarca() { return marca; }
    public int getCilindraje() { return cilindraje; }
    public double getPrecio() { return precio; }
    public String getColor() { return color; }

    public void setCilindraje(int cilindraje) { this.cilindraje = cilindraje; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        return marca + " - " + cilindraje + "cc - $" + precio + " - " + color;
    }
}

// Clase RegistroMotocicletas
class RegistroMotocicletas {
    private ArrayList<Motocicleta> lista;

    public RegistroMotocicletas() {
        lista = new ArrayList<>();
        lista.add(new Motocicleta("Yamaha", 150, 3000, "Rojo"));
        lista.add(new Motocicleta("Honda", 200, 3500, "Negro"));
        lista.add(new Motocicleta("Suzuki", 250, 4000, "Azul"));
        lista.add(new Motocicleta("Kawasaki", 300, 5500, "Verde"));
        lista.add(new Motocicleta("Ducati", 600, 9000, "Blanco"));
    }

    public ArrayList<Motocicleta> getLista() {
        return lista;
    }

    public void agregar(Motocicleta m) {
        lista.add(m);
    }

    public Motocicleta buscarPorMarca(String marca) {
        for (Motocicleta m : lista) {
            if (m.getMarca().equalsIgnoreCase(marca)) {
                return m;
            }
        }
        return null;
    }

    public void actualizar(String marca, int nuevoCilindraje, double nuevoPrecio, String nuevoColor) {
        Motocicleta m = buscarPorMarca(marca);
        if (m != null) {
            m.setCilindraje(nuevoCilindraje);
            m.setPrecio(nuevoPrecio);
            m.setColor(nuevoColor);
        }
    }

    public void ordenarPorPrecio() {
        lista.sort(Comparator.comparingDouble(Motocicleta::getPrecio));
    }
}

// Clase principal con interfaz Swing
public class ProyectoMotocicletasCompleto extends JFrame {
    RegistroMotocicletas registro = new RegistroMotocicletas();

    public ProyectoMotocicletasCompleto() {
        JTabbedPane tabs = new JTabbedPane();

        JTextArea txtInicio = new JTextArea();
        txtInicio.setEditable(false);
        for (Motocicleta m : registro.getLista()) {
            txtInicio.append(m.toString() + "\n");
        }
        tabs.add("Inicio", new JScrollPane(txtInicio));

        JPanel ingreso = new JPanel(new GridLayout(5, 2));
        JTextField txtMarcaIng = new JTextField();
        JTextField txtCilindrajeIng = new JTextField();
        JTextField txtPrecioIng = new JTextField();
        JComboBox<String> comboColorIng = new JComboBox<>(new String[] {"Rojo", "Negro", "Azul", "Blanco", "Verde"});
        JButton btnAgregar = new JButton("Agregar");

        btnAgregar.addActionListener(e -> {
            try {
                String marca = txtMarcaIng.getText();
                int cc = Integer.parseInt(txtCilindrajeIng.getText());
                double precio = Double.parseDouble(txtPrecioIng.getText());
                String color = (String) comboColorIng.getSelectedItem();

                if (precio < 1500 || precio > 30000) {
                    JOptionPane.showMessageDialog(this, "Precio fuera de rango.");
                    return;
                }

                registro.agregar(new Motocicleta(marca, cc, precio, color));
                JOptionPane.showMessageDialog(this, "Motocicleta agregada.");
                txtInicio.append(marca + " - " + cc + "cc - $" + precio + " - " + color + "\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos.");
            }
        });

        ingreso.add(new JLabel("Marca:")); ingreso.add(txtMarcaIng);
        ingreso.add(new JLabel("Cilindraje:")); ingreso.add(txtCilindrajeIng);
        ingreso.add(new JLabel("Precio:")); ingreso.add(txtPrecioIng);
        ingreso.add(new JLabel("Color:")); ingreso.add(comboColorIng);
        ingreso.add(new JLabel("")); ingreso.add(btnAgregar);
        tabs.add("Ingreso", ingreso);

        JPanel actualizar = new JPanel(new GridLayout(5, 2));
        JTextField txtMarcaAct = new JTextField();
        JTextField txtCilindrajeAct = new JTextField();
        JTextField txtPrecioAct = new JTextField();
        JComboBox<String> comboColorAct = new JComboBox<>(new String[] {"Rojo", "Negro", "Azul", "Blanco", "Verde"});
        JButton btnActualizar = new JButton("Actualizar");

        btnActualizar.addActionListener(e -> {
            try {
                String marca = txtMarcaAct.getText();
                int cc = Integer.parseInt(txtCilindrajeAct.getText());
                double precio = Double.parseDouble(txtPrecioAct.getText());
                String color = (String) comboColorAct.getSelectedItem();

                if (precio < 1500 || precio > 30000) {
                    JOptionPane.showMessageDialog(this, "Precio fuera de rango.");
                    return;
                }

                Motocicleta m = registro.buscarPorMarca(marca);
                if (m != null) {
                    registro.actualizar(marca, cc, precio, color);
                    JOptionPane.showMessageDialog(this, "Actualizado.");
                    txtInicio.setText("");
                    for (Motocicleta moto : registro.getLista()) {
                        txtInicio.append(moto + "\n");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No encontrada.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos.");
            }
        });

        actualizar.add(new JLabel("Marca:")); actualizar.add(txtMarcaAct);
        actualizar.add(new JLabel("Nuevo Cilindraje:")); actualizar.add(txtCilindrajeAct);
        actualizar.add(new JLabel("Nuevo Precio:")); actualizar.add(txtPrecioAct);
        actualizar.add(new JLabel("Nuevo Color:")); actualizar.add(comboColorAct);
        actualizar.add(new JLabel("")); actualizar.add(btnActualizar);
        tabs.add("Actualizar", actualizar);

        JPanel buscar = new JPanel(new BorderLayout());
        JTextField txtBuscarMarca = new JTextField(10);
        JTextArea txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JButton btnBuscar = new JButton("Buscar");
        JButton btnOrdenar = new JButton("Ordenar por Precio");

        btnBuscar.addActionListener(e -> {
            Motocicleta m = registro.buscarPorMarca(txtBuscarMarca.getText());
            txtResultado.setText((m != null) ? "Encontrada: " + m : "No encontrada.");
        });

        btnOrdenar.addActionListener(e -> {
            registro.ordenarPorPrecio();
            txtResultado.setText("");
            for (Motocicleta m : registro.getLista()) {
                txtResultado.append(m + "\n");
            }
        });

        JPanel topBuscar = new JPanel();
        topBuscar.add(new JLabel("Marca:"));
        topBuscar.add(txtBuscarMarca);
        topBuscar.add(btnBuscar);
        topBuscar.add(btnOrdenar);

        buscar.add(topBuscar, BorderLayout.NORTH);
        buscar.add(new JScrollPane(txtResultado), BorderLayout.CENTER);
        tabs.add("Buscar / Ordenar", buscar);

        add(tabs);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ProyectoMotocicletasCompleto();
    }
}
