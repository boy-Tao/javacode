package com.operation;
import com.book.Book;
import com.book.BookList;
 /*
 *@author：Tao
 *@date：2019/11/24
 */
public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书:");
        System.out.println("请输入要借阅的书名:");
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
        if (book.isBorrowed()) {
            System.out.println("此书已经被借出去!");
        }else {
            book.setBorrowed(true);
            System.out.println("借阅成功!");
        }
    }
}
