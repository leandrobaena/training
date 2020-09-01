
package mypeopleexample;

public class Teacher extends Person {
    
    public Teacher() {
        System.out.println("Teacher: constructor is called");
    }
    
    private String subject;
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
