package operaciones;
public class Operaciones{
    public int sumar (int valor1, int valor2){
        int numero;
        numero = valor1 + valor2;
        return numero;
    }
    /**
    13      * Constructor.
    14      * @param valor1 : minuendo
    15      * @param valor2 : sustraendo
    16      * @return numero : diferencia
    17      */
    public int restar (int valor1, int valor2){
        int numero;
        numero = valor1 - valor2;
        return numero;
    }
    /**
    13      * Constructor.
    14      * @param valor1 : factor
    15      * @param valor2 : factor
    16      * @return numero : producto
    17      */
    public int multiplicar (int valor1, int valor2){
        int numero;
        numero = valor1 * valor2;
        return numero;
    }
    /**
    13      * Constructor.
    14      * @param valor1 : dividendo
    15      * @param valor2 : divisor
    16      * @return numero : cociente
    17      */
    public int dividir (int valor1, int valor2){
        int numero;
        numero = valor1 / valor2;
        return numero;
    }
    /**
    13      * Constructor.
    14      * @param valor1 : dividendo
    15      * @param valor2 : divisor
    16      * @return numero : resto
    17      */
    public int resto (int valor1, int valor2){
        int numero;
        numero = valor1 % valor2;
        return numero;
    }
}