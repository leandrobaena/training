
public class StudentRecord {

    // Declare instance variables.
    private String name;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private double average;
    private int age;

    // Declare static variables.
    private static int studentCount = 0;

    // Default constructor
    public StudentRecord() {
    }

    // Constructor that gets single parameter
    public StudentRecord(String name) {
        this.name = name;
    }

    // Constructor that gets two parameters
    public StudentRecord(String name, double mGrade) {
        this(name);
        mathGrade = mGrade;
    }

    // Constructor that gets three parameters
    public StudentRecord(String name, double mGrade, double eGrade) {
        this(name, mGrade);
        englishGrade = eGrade;
    }

    // Constructor that gets four parameters
    public StudentRecord(String name, double mGrade, double eGrade, double sGrade) {
        this(name, mGrade, eGrade);
        scienceGrade = sGrade;
    }

    // Constructor that gets four parameters
    public StudentRecord(String name, double mGrade, double eGrade, double sGrade, int age) {
        this(name, mGrade, eGrade);
        scienceGrade = sGrade;
        this.age = age;
    }

    // Constructor that gets four parameters
    public StudentRecord(String name, double mGrade, double eGrade, double sGrade,  int age, double average) {
        this(name, mGrade, eGrade, sGrade, age);
        this.average = average;
    }

    /**
     * Returns the name of the student
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the student
     *
     * @param temp
     */
    public void setName(String temp) {
        name = temp;
    }

    /**
     * Computes the average of the english,math and science grades
     *
     * @return
     */
    public double getAverage() {
        double result;
        result = (getMathGrade() + getEnglishGrade() + getScienceGrade()) / 3;
        return result;
    }

    /**
     * Returns the number of instances of StudentRecords
     *
     * @return
     */
    public static int getStudentCount() {
        return studentCount;
    }

    /**
     * Increases the number of instances of StudentRecords. This is a static
     * method.
     */
    public static void increaseStudentCount() {
        studentCount++;
    }

    // Instance methods
    public double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(double mathGrade) {
        this.mathGrade = mathGrade;
    }

    public double getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(double englishGrade) {
        this.englishGrade = englishGrade;
    }

    public double getScienceGrade() {
        return scienceGrade;
    }

    public void setScienceGrade(double scienceGrade) {
        this.scienceGrade = scienceGrade;
    }
}
