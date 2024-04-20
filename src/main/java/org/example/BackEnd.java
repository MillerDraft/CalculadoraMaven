import java.text.DecimalFormat;

public class BackEnd{
    public double handleOperation(String operation, double num1, double num2){
        double result = 0;

        switch (operation){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0){
                    result = num1 / num2;
                }
                break;
        }

        // Round the result to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");

        result = Double.parseDouble(df.format(result));
        return result;

    }
}

