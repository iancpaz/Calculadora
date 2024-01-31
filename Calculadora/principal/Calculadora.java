package principal;

import menu.Menu;
import operaciones.Operaciones;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Ejemplo: Calculadora
 * @author Asier - fprg5000
 * @version 24.01.2024
 */
public class Calculadora {

    // Configuración del sistema de logging
    private static final Logger logger = Logger.getLogger(Calculadora.class.getName());

    static {
        try {
            // Configuración del manejador de archivos para el registro
            FileHandler fileHandler = new FileHandler("operaciones.log"); // Nombre del archivo de registro
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int[2];

        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();

        do {
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();

            try {
                switch (operacion.toLowerCase()) {
                    case "+":
                        resultado = operaciones.sumar(operandos[0], operandos[1]);
                        break;
                    case "-":
                        resultado = operaciones.restar(operandos[0], operandos[1]);
                        break;
                    case "*":
                        resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                        break;
                    case "/":
                        resultado = operaciones.dividir(operandos[0], operandos[1]);
                        break;
                    case "%":
                        resultado = operaciones.resto(operandos[0], operandos[1]);
                        break;
                    default:
                        System.out.println("Operación no válida");
                        continue;
                }

                System.out.println("Resultado: " + resultado);
                String mensaje = String.format("Operación: %s, Operandos: %d, %d, Resultado: %d", operacion, operandos[0], operandos[1], resultado);
                logger.log(Level.FINE, mensaje);

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
                String warningMessage = String.format("Error al realizar la operación: %s, Operandos: %d, %d", operacion, operandos[0], operandos[1]);
                logger.log(Level.WARNING, warningMessage);
            }

        } while (menu.repetir());
    }
}
