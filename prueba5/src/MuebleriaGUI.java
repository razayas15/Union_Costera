import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MuebleriaGUI extends JFrame {
    private Muebleria muebleria;
    private JTextField tipoField, materialField, stockField, precioField;
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> criterioComboBox, ordenComboBox;
    private List<Venta> ventas;

    public MuebleriaGUI() {
        muebleria = new Muebleria();
        ventas = new ArrayList<>();

        setTitle("Muebleria");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        crearMenu();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

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

        panel.add(new JLabel("Ordenar por:"));
        criterioComboBox = new JComboBox<>(new String[]{"Precio", "Stock"});
        panel.add(criterioComboBox);

        panel.add(new JLabel("Orden:"));
        ordenComboBox = new JComboBox<>(new String[]{"Ascendente", "Descendente"});
        panel.add(ordenComboBox);

        add(panel, BorderLayout.NORTH);

        String[] columnNames = {"Tipo", "Material", "Stock", "Precio"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 4));

        JButton venderButton = new JButton("Vender Mueble");
        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venderMueble();
            }
        });
        southPanel.add(venderButton);

        JButton eliminarButton = new JButton("Eliminar Mueble");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarMueble();
            }
        });
        southPanel.add(eliminarButton);

        JButton ordenarButton = new JButton("Ordenar");
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarMuebles();
            }
        });
        southPanel.add(ordenarButton);

        JButton reporteButton = new JButton("Generar Reporte");
        reporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarReporte();
            }
        });
        southPanel.add(reporteButton);

        add(southPanel, BorderLayout.SOUTH);

        actualizarTabla();
    }

    private void agregarMueble() {
        try {
            String tipo = tipoField.getText();
            String material = materialField.getText();
            int stock = Integer.parseInt(stockField.getText());
            int precio = Integer.parseInt(precioField.getText());

            Mueble mueble = new Mueble(tipo, material, stock, precio);
            muebleria.agregarOModificarMueble(mueble);
            actualizarTabla();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa valores válidos para Stock y Precio.");
        }
    }

    private void buscarYMostrarMuebles() {
        String tipo = tipoField.getText();
        String material = materialField.getText();

        List<Mueble> resultados = muebleria.buscarYOrdenarMuebles(tipo, material, null);
        actualizarTabla(resultados);
    }

    private void venderMueble() {
        try {
            String tipo = tipoField.getText();
            String material = materialField.getText();
            muebleria.venderMueble(tipo, material);
            ventas.add(new Venta(tipo, material));
            actualizarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void eliminarMueble() {
        String tipo = tipoField.getText();
        String material = materialField.getText();
        muebleria.eliminarMueble(tipo, material);
        actualizarTabla();
    }

    private void ordenarMuebles() {
        String criterio = criterioComboBox.getSelectedItem().toString();
        String orden = ordenComboBox.getSelectedItem().toString();
        List<Mueble> muebles = muebleria.getInventario();
        muebleria.ordenar(muebles, criterio + " " + orden);
        actualizarTabla(muebles);
    }

    private void mostrarReporte() {
        Reporte reporte = new Reporte(muebleria.getInventario(), ventas);
        String reporteInventario = reporte.generarReporteInventario();
        String reporteVentas = reporte.generarReporteVentas();

        JTextArea textArea = new JTextArea();
        textArea.append(reporteInventario + "\n\n" + reporteVentas);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JOptionPane.showMessageDialog(this, scrollPane, "Reporte", JOptionPane.PLAIN_MESSAGE);
    }

    private void actualizarTabla() {
        actualizarTabla(muebleria.getInventario());
    }

    private void actualizarTabla(List<Mueble> muebles) {
        tableModel.setRowCount(0);
        for (Mueble mueble : muebles) {
            tableModel.addRow(new Object[]{mueble.getTipo(), mueble.getMaterial(), mueble.getStock(), mueble.getPrecio()});
        }
    }

    private void crearMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu ayudaMenu = new JMenu("Ayuda");
        JMenuItem acercaDeItem = new JMenuItem("Acerca de");
        acercaDeItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Mueblería v1.0"));
        ayudaMenu.add(acercaDeItem);

        menuBar.add(ayudaMenu);

        setJMenuBar(menuBar);
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

