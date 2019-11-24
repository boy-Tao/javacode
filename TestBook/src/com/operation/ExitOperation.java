package com.operation;
import com.book.BookList;
 /*
 *@author：Tao
 *@date：2019/11/24
 */
public class ExitOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统!");
        System.exit(1);
    }
}
