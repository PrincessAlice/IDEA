package class_definition;

class Student{
    int gender;
    //0== 女  1==男
    public Student(int gender){
        this.gender = gender;
    }
}

interface  Filter{
    boolean filter(Student student);
}
public class LambdaExample {
    public static void main(String[] args) {
        Student[] students = {
           new Student(1),
           new Student(1),
           new Student(0),
           new Student(0),
           new Student(0),
           new Student(0),
           new Student(1),
           new Student(1),
        };

        class FemaleFilter implements Filter{
            @Override
            public boolean filter(Student student){
                return student.gender == 0;
            }
        }
        Filter filter = new FemaleFilter();
        queryStudent(students,s -> s.gender == 0);
    }
    static void queryStudent(Student[] students,Filter condition){
        for(Student student: students){
            if(condition.filter(student)){
                System.out.println(student);
            }
        }
    }

}
