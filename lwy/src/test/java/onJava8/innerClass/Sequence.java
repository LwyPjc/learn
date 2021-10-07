package onJava8.innerClass;

import onJava8.service.Selector;

public class Sequence {
    private Object[] arr;
    private int next = 0;

    public Sequence(int size) {
        arr = new Object[size];
    }

    private void add(int i) {
        if (i < arr.length) {
            arr[next++] = i;
        }
    }

    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i >= arr.length;
        }

        @Override
        public Object current() {
            return arr[i];
        }

        @Override
        public void add() {
            if (i < arr.length) {
                i++;
            }
        }
    }

    public Selector getSelector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        Selector selector = sequence.getSelector();

        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        while (!selector.end()) {
            System.out.println(selector.current()+" ");
            selector.add();
        }
    }


}
