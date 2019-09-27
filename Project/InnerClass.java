package class_definition;

interface IA{
    void method();
}
public class InnerClass {
    class A{}
    IA a = new IA(){
        @Override
        public void method(){}
    };

    void method(){
        class B{}
        IA b=new IA(){
            @Override
            public void method(){}
        };
    }
}
