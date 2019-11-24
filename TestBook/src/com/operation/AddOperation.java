package com.operation;
import com.book.Book;
import com.book.BookList;
 /*
 *@author：Tao
 *@date：2019/11/24
 */
public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请添加图书:");
        System.out.println("请输入图书的书名:");
        String name = scanner.next();
        System.out.println("请输入图书的作者:");
        String author = scanner.next();
        System.out.println("请输入图书的价格:");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型:");
        String type = scanner.next();

        Book book = new Book(name,author,price,type);
        int pos = bookList.getUsedSize();
        bookList.setBooks(pos,book);
        bookList.setUsedSize(pos+1);
    }
}
