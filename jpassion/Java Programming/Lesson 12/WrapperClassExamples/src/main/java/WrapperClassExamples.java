
class WrapperClassExamples {

    public static void main(String args[]) {

        boolean booleanVar = 1 > 2;
        Boolean booleanObj = new Boolean("TRue");
        Boolean booleanObj2 = new Boolean(booleanVar);

        System.out.println("booleanVar = " + booleanVar);
        System.out.println("booleanObj = " + booleanObj);
        System.out.println("booleanObj2 = "
                + booleanObj2);
        System.out.println("compare 2 wrapper objects: "
                + booleanObj.equals(booleanObj2));

        /* object to primitive */
        booleanVar = booleanObj.booleanValue();
        System.out.println("booleanVar = " + booleanVar);

        int intPrimitive = 5;
        Integer intObject = new Integer(intPrimitive);
        System.out.println("intObject = " + intObject);

        int intPrimitive2 = intObject.intValue();
        System.out.println("intPrimitive2 = " + intPrimitive2);

        long longPrimitive = 5;
        Long longObject = new Long(longPrimitive);
        System.out.println("longObject = " + longObject);

        long longPrimitive2 = longObject.longValue();
        System.out.println("longPrimitive2 = " + longPrimitive2);

        double doublePrimitive = 5;
        Double doubleObject = new Double(doublePrimitive);
        System.out.println("doubleObject = " + doubleObject);

        double doublePrimitive2 = doubleObject.doubleValue();
        System.out.println("doublePrimitive2 = " + doublePrimitive2);

    }
}