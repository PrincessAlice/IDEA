package Databases;

import  Classes.Book;

public interface Where<E> {
    boolean test(E e);
}
