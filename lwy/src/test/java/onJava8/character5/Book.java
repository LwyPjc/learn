package onJava8.character5;

public class Book {
    boolean checkedOut = false;
    Book(boolean checkOut){
        checkedOut = checkOut;
    }

    void checkIn(){
        checkedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {

        if(checkedOut){
            System.out.println("Error: checked out");
        }
    }

}

class TerminationCondition{
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
//        new Nap(1);
    }
}
