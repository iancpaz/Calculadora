package principal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import menu.Menu;
import operaciones.Operaciones;

public class Calculadora {
	public static final Logger LOGGER = Logger.getLogger("Nombre del logger");
	public static void main(String[] args)throws IOException {
		/**
		 * El main en el que se invocan los metodos.
		 *
		 * @author Ian Castaño
		 * @version 24.01.2024
		 */

		LOGGER.setLevel(Level.ALL);
		LOGGER.setUseParentHandlers(false);
		int resultado = 0;
		String operacion = "";
		int[] operandos = new int[2];

		ConsoleHandler consoleHandler =new ConsoleHandler();
		FileHandler fileHandler=null;
		LOGGER.addHandler(consoleHandler);
		
		try {
			fileHandler=new FileHandler();
			LOGGER.addHandler(fileHandler);
		}catch(SecurityException e) {
			e.printStackTrace();
		}
		
		Menu menu = new Menu();
		Operaciones operaciones = new Operaciones();

		do {
			operandos = menu.pedirNumeros();
			operacion = menu.menuOpciones();

			if (operacion.equalsIgnoreCase("+")) {
				resultado = operaciones.sumar(operandos[0], operandos[1]);
				LOGGER.log(Level.FINE, "Suma realizada correctamente.");
				
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("-")) {
				resultado = operaciones.restar(operandos[0], operandos[1]);
				LOGGER.log(Level.FINE, "Resta realizada correctamente.");
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("*")) {
				resultado = operaciones.multiplicar(operandos[0], operandos[1]);
				LOGGER.log(Level.FINE, "Multiplicacion realizada correctamente.");
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("/")) {
				try {
				resultado = operaciones.dividir(operandos[0], operandos[1]);
				LOGGER.log(Level.FINE, "Division realizada correctamente.");
				}catch(ArithmeticException e) {
					LOGGER.log(Level.WARNING, "Intento de dividir por cero");
					resultado=0;
				}
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("%")) {
				resultado = operaciones.resto(operandos[0], operandos[1]);
				LOGGER.log(Level.FINE, "Resto realizado correctamente.");
				System.out.println("Resultado: " + resultado);
			} else {
				System.out.println("Operaci�n no v�lida");
			}
		} while (menu.repetir());

	}






	public static void html(String operacion, int[] operandos, int resultado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/principal/TablaCalculadora.html", true))) {
            // Comprobar si el fichero está vacío y, en ese caso, escribir el encabezado de la tabla
            int i = 2;
        	if (i==2) {
                writer.write("<html> /n <head><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"></head> /n <body>  /n");
                writer.write("<table> /n<tr> /n <th>Operación</th> /n <th>Operando 1</th> /n <th>Operando 2</th> /n <th>Resultado</th> /n </tr> /n");
            }

            writer.write("<tr> /n");
            writer.write("<td>" + operacion + "</td>/n");
            writer.write("<td>" + operandos[0] + "</td> /n");
            writer.write("<td>" + operandos[1] + "</td> /n");
            writer.write("<td>" + resultado + "</td> /n");
            writer.write("</tr>/n");
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    
}}