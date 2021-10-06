
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

final public class main {

    //Suma
    final static IntBinaryOperator suma = (num1, num2) -> num1 + num2;
    //Resta
    final static IntBinaryOperator resta = (num1, num2) -> num1 - num2;
    //Multiplicación
    final static IntBinaryOperator multiplicacion = (num1, num2) -> {
        Integer absNum1 = Math.abs(num1);
        Integer absNum2 = Math.abs(num2);
        Integer result =  IntStream.range(0, absNum2+1).
                reduce((acc, current)->suma.applyAsInt(absNum1, acc)).
                getAsInt();
        return (num1 < 0 && num2 < 0)  || (num1 > 0 && num2 > 0)  ? result : -result;
    };
    //División
    final static IntBinaryOperator division = (num1, num2) -> {
        if (num2 == 0) throw new IllegalArgumentException("0 No es un número válido");
        Integer absDividend = Math.abs(num1);
        Integer absDivisor = Math.abs(num2);
        Integer result = IntStream.range(0, absDividend+1)
                .reduce((acc, num) ->( multiplicacion.applyAsInt(num, absDivisor) <= absDividend) ? suma.applyAsInt(acc,1): acc)
                .orElse(0);
        return (num1 < 0 && num2 < 0)  || (num1 > 0 && num2 > 0)  ? result : -result;
    };

     public static void main(String[] args) {

         System.out.println(suma.applyAsInt(1, 1));
         System.out.println(resta.applyAsInt(3, 2));
         System.out.println(multiplicacion.applyAsInt(2, -2));
         System.out.println(division.applyAsInt(10, 2));
    }
}
