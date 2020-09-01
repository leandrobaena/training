package mypackage;

public class Main {
    
    public static void main(String[] args) {

        // Create object instance of static nested class
        OuterClass.StaticNestedClass staticNestedObject1 = new OuterClass.StaticNestedClass();
        System.out.println("Access data2 from StaticNested class = " + staticNestedObject1.data2);
        staticNestedObject1.myStaticNestedMethod();

        // Create another object instance of static nested class
        OuterClass.StaticNestedClass staticNestedObject2 = new OuterClass.StaticNestedClass();
        if (staticNestedObject1 != staticNestedObject2){
            System.out.println("staticNestedObject1 != staticNestedObject2");
        }
        
    }
    
}
