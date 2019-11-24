package com.operation;
import com.book.Book;
import com.book.BookList;
 /*
 *@author：Tao
 *@date：2019/11/24
 */
public class FindOperation implements IOperation{
     @Override
     public void work(BookList bookList) {
         System.out.println("查找图书:");
         System.out.println("请输入要查找的书名:");
         String name = scanner.next();
         int i = 0;
         Book book = null;
         for ( ;i < bookList.getUsedSize();i++) {
             book = bookList.getBook(i);
             if (book.getName().equals(name)) {
                 break;
             }
         }
         if (i == bookList.getUsedSize()) {
             System.out.println("没有此书!");
             return;
         }
         book = bookList.getBook(i);
         System.out.println(book);
         System.out.println("找到此书!");
     }
}
