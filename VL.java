import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VL extends JFrame {  // Aquí extiende JFrame
    private JTextField textField;  // Campo de texto
    private JLabel resultadoLabel1;
    private JLabel resultadoLabel;  // Etiqueta de resultado

    // Método para realizar la búsqueda lineal
    public static int busquedaLineal(int[] arreglo, int objetivo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) {
                return i; // Devuelve el índice donde se encuentra el objetivo
            }
        }
        return -1; // Si no se encuentra el objetivo
    }

    // Constructor de la clase VL
    public VL() {
        // Configurar la ventana JFrame
        setTitle("Búsqueda Lineal");  // Título de la ventana
        setSize(450, 300);  // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cerrar la aplicación al cerrar la ventana
        setLayout(null);  // Usar un layout nulo para posicionar componentes manualmente

        // Crear el arreglo de ejemplo
        int[] arreglo = {12, 45, 23, 89, 56, 77, 99, 38};

        // Crear los componentes de la interfaz
        JLabel label = new JLabel("INGRESE EL NÚMERO QUE DESEA BUSCAR");
        label.setBounds(10, 11, 200, 14);  // Posición y tamaño
        add(label);

        textField = new JTextField();
        textField.setBounds(10, 36, 200, 20);  // Posición y tamaño
        add(textField);

        JButton buscarButton = new JButton("INICIAR");
        buscarButton.setBounds(10, 67, 89, 23);  // Posición y tamaño
        add(buscarButton);

        resultadoLabel = new JLabel("RESULTADO:");
        resultadoLabel.setBounds(10, 101, 200, 14);  // Posición y tamaño
        add(resultadoLabel);

        // Acción al presionar el botón "INICIAR"
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener el número ingresado por el usuario
                    int objetivo = Integer.parseInt(textField.getText());  // Tomar el valor del JTextField

                    // Llamar al método de búsqueda lineal
                    int resultado = busquedaLineal(arreglo, objetivo);

                    // Mostrar el resultado en la interfaz
                    if (resultado != -1) {
                        resultadoLabel.setText("El número " + objetivo + " se encuentra en el índice: " + resultado);
                    } else {
                        resultadoLabel.setText("El número " + objetivo + " no se encontró.");
                    }
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Por favor ingrese un número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        VL window = new VL();  // Crear la instancia de la clase VL
        window.setVisible(true);
    }
}