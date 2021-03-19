package onJava8.innerClass;

public class DotNew {
    public class Inner{
        public void Print(){
            System.out.println("哈哈😄");
        }
    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
        dni.Print();
    }
}
