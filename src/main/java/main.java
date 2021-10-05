
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

final public class main {

    //Suma
    final static IntBinaryOperator suma = (num1, num2) -> num1 + num2;
    //Resta
    final static IntBinaryOperator resta = (num1, num2) -> num1 - num2;
    //Multiplicación
    final static IntBinaryOperator multiplicacion = (num1, num2) -> {
        return IntStream.range(0, Math.abs(num2) + 1).reduce((acumulado, numero) ->
        suma.applyAsInt(num1, acumulado)).getAsInt();
    };
    //División
    final static IntBinaryOperator division = (num1, num2) -> {
        return IntStream.range(0, num1)
                .reduce((acumulado, numero) -> multiplicacion
                        .applyAsInt(numero, num2)<=num1? suma
                        .applyAsInt(acumulado, 1):acumulado)
                .orElse(0);
    };

     public static void main(String[] args) {

         System.out.println(suma.applyAsInt(1, 1));
         System.out.println(resta.applyAsInt(3, 2));
         System.out.println(multiplicacion.applyAsInt(2, -2));
         System.out.println(division.applyAsInt(10, 2));
    }
}
