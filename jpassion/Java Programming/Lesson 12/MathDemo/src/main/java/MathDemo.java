
class MathDemo {
    public static void main(String args[]) {
        System.out.println("absolute value of -5: " +                                       Math.abs(-5));
        System.out.println("absolute value of 5: " +                                        Math.abs(5));
        System.out.println("random number(max is 10): " +
                Math.random()*10);
        System.out.println("max of 3.5 and 1.2: " +
                Math.max(3.5,1.2));
        System.out.println("min of 3.5 and 1.2: " +
                Math.min(3.5,1.2));
        System.out.println("ceiling of 3.5: " +
                Math.ceil(3.5));
        System.out.println("floor of 3.5: " +
                Math.floor(3.5));
        System.out.println("e raised to 1: " +
                Math.exp(1));
        System.out.println("log 10: " + Math.log(10));
        System.out.println("10 raised to 3: " +
                Math.pow(10,3));
        System.out.println("rounded off value of pi: " +
                Math.round(Math.PI));
        System.out.println("square root of 5 = " +
                Math.sqrt(5));
        System.out.println("10 radian = " +
                Math.toDegrees(10) + " degrees");
        System.out.println("sin(90): " +
                Math.sin(Math.toRadians(90)));
    }
}