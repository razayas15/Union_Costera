import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MuebleriaGUI extends JFrame {
    private Muebleria muebleria;
    private JTextField tipoField, materialField, stockField, precioField;
    private JTable table;
    private DefaultTableModel tableModel;

    public MuebleriaGUI() {
        muebleria = new Muebleria();

        // Crear diferentes tipos de muebles y agregarlos al inventario de la mueblería
        Mueble silla = new Mueble("Silla", "Madera", 12, 150);
        Mueble mesa = new Mueble("Mesa", "Metal", 5, 300);
        Mueble ventana = new Mueble("Ventana", "Vidrio", 8, 200);
        Mueble puerta = new Mueble("Puerta", "Madera", 6, 250);
        Mueble ropero = new Mueble("Ropero", "Madera", 4, 400);

        muebleria.agregarOModificarMueble(silla);
        muebleria.agregarOModificarMueble(mesa);
        muebleria.agregarOModificarMueble(ventana);
        muebleria.agregarOModificarMueble(puerta);
        muebleria.agregarOModificarMueble(ropero);

        setTitle("Muebleria");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        panel.add(tipoField);

        panel.add(new JLabel("Material:"));
        materialField = new JTextField();
        panel.add(materialField);

        panel.add(new JLabel("Stock:"));
        stockField = new JTextField();
        panel.add(stockField);

        panel.add(new JLabel("Precio:"));
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

        JButton buscarButton = new JButton("Buscar Mueble");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarYMostrarMuebles();
            }
        });
        panel.add(buscarButton);

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

    // Si hay un campo vacio tira error
    private void agregarMueble() {
        String tipo = tipoField.getText();
        String material = materialField.getText();
        int stock = Integer.parseInt(stockField.getText());
        int precio = Integer.parseInt(precioField.getText());

        Mueble mueble = new Mueble(tipo, material, stock, precio);
        muebleria.agregarOModificarMueble(mueble);

        actualizarTabla();
    }

    // Arreglar buscador!!!!!!!!!!!!!!!!!
    private void buscarYMostrarMuebles() {

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
}
