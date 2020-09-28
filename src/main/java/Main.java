import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;


public class Main {

    public static void main(String[] args) {

        Function logb = new Function("logb", 2) {
            @Override
            public double apply(double... args) {
                return Math.log(args[0])/Math.log(args[1]);
            }
        };

        String template = "logb(8,2)";
        Expression expression = new ExpressionBuilder(template)
                .function(logb)
                .build();

        presentResult(expression, template);

        String template2 = "2^2 + sin(180) + a";
        Expression expression2 = new ExpressionBuilder(template2)
                .variable("a")
                .build()
                .setVariable("a", 1)
                ;

        presentResult(expression2, template2);


    }

    public static void presentResult(Expression expression, String template){
        double result = expression.evaluate();

        System.out.println("RESULT OF: ");
        System.out.println(template);
        System.out.println("IS:");
        System.out.println(result);
        System.out.println("-----------------------------------------------------");
    }
}
