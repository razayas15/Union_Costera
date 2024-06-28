import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MuebleriaGUI extends JFrame {
    private Muebleria muebleria;
    private JTextField tipoField, materialField, stockField, precioField;
    private JTable table;
    private DefaultTableModel tableModel;

    public MuebleriaGUI() {
        muebleria = new Muebleria();

        setTitle("Muebleria");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Tipo*:"));
        tipoField = new JTextField();
        panel.add(tipoField);

        panel.add(new JLabel("Material:"));
        materialField = new JTextField();
        panel.add(materialField);

        panel.add(new JLabel("Stock*:"));
        stockField = new JTextField();
        panel.add(stockField);

        panel.add(new JLabel("Precio*:"));
        precioField = new JTextField();
        panel.add(precioField);

        JButton addButton = new JButton("Agregar Mueble");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarMueble();
            }
        });
        panel.add(addButton);

        add(panel, BorderLayout.NORTH);

        String[] columnNames = {"Tipo", "Material", "Stock", "Precio"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton mostrarTodosButton = new JButton("Mostrar Todos");
        mostrarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodosLosMuebles();
            }
        });
        add(mostrarTodosButton, BorderLayout.SOUTH);
    }

    private void agregarMueble() {
        String tipo = tipoField.getText();
        String material = materialField.getText();
        String stockStr = stockField.getText();
        String precioStr = precioField.getText();

        if (tipo.isEmpty() || precioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa Tipo y Precio.");
            return;
        }

        int stock;
        try {
            stock = Integer.parseInt(stockStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Stock debe ser un número entero válido.");
            return;
        }

        int precio;
        try {
            precio = Integer.parseInt(precioStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio debe ser un número entero válido.");
            return;
        }

        Mueble mueble = new Mueble(tipo, material, stock, precio);
        muebleria.agregarOModificarMueble(mueble);
        actualizarTabla();
    }

    private void mostrarTodosLosMuebles() {
        actualizarTabla(muebleria.getInventario());
    }

    private void actualizarTabla() {
        actualizarTabla(muebleria.getInventario());
    }

    private void actualizarTabla(List<Mueble> muebles) {
        tableModel.setRowCount(0);
        for (Mueble mueble : muebles) {
            Object[] rowData = {
                    mueble.getTipo(),
                    mueble.getMaterial(),
                    mueble.getStock(),
                    mueble.getPrecio()
            };
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MuebleriaGUI().setVisible(true);
            }
        });
    }
}
