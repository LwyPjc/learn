package datastructure.array;

public class Student {

    private String name;
    private int score;

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> stus = new Array<>(10);
        stus.add(new Student("小明",50));
        stus.add(new Student("小红",80));
        System.out.println(stus.toString());
    }
}
