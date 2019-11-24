package com.operation;
import com.book.BookList;
import java.util.Scanner;
 /*
 *@author：Tao
 *@date：2019/11/24
 */
public interface IOperation {
    Scanner scanner = new Scanner(System.in);
    void work(BookList bookList);
}
