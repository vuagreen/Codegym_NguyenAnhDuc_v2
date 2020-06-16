public class Caculate {

    public static float caculate(float s1, float s2, char op) {
        switch (op) {
            case '+':
                return s1 + s2;

            case '-':
                return s1 - s2;

            case '*':
                return s1 * s2;

            case '/':
                if (s2 != 0) {
                    return s1 / s2;
                } else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }

    }

}
