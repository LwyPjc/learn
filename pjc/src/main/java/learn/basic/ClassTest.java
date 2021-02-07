package learn.basic;

/**
 * @author : MichealPan
 * @description : 内部类测试
 * @create : 2021-02-07 11:32
 */
public class ClassTest {

    class Inner {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private void sayHello(String name) {
        Inner inner = new Inner();
        inner.setName(name);
        System.out.println(inner.getName());
    }


}
