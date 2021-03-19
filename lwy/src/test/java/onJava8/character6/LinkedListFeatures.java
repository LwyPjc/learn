package onJava8.character6;

import onJava8.Pets.Pet;

import java.util.LinkedList;

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pet.list());
        System.out.println(pets);
        System.out.println("pets.getFirst() "+pets.getFirst());
        System.out.println("pets.element() "+pets.element());
        System.out.println("pets.peek() "+pets.peek());
        System.out.println("pets.remove() "+pets.remove());
        System.out.println("pets.removeFirst() "+pets.removeFirst());
        System.out.println("pets.poll() "+pets.poll());
        System.out.println(pets);
    }
}
