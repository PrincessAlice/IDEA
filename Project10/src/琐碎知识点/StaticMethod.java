package class_definition;

public class StaticMethod {
    void method(){}

    class Inner{
        void method(){
            StaticMethod.this.method();
        }
    }

    static void staticMethod(){
        /**
         * 1. 没法使用 this 关键字
         * 2. 没法直接访问普通属性
         * 3. 没法直接调用普通方法
         */
        StaticMethod o = new StaticMethod();
        o.method();
    }
}
