package com.nucsoft.bookstore.special;

import com.nucsoft.bookstore.bean.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by solverpeng on 2016/6/12.
 */
public class Cart {
    private Map<Integer, CartItem> itemMap = new HashMap<Integer, CartItem>();

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> itemMap) {
        this.itemMap = itemMap;
    }

    public boolean isCartEmpty() {
        return itemMap.isEmpty();
    }

    public void add2Cart(Book book) {
        boolean isExist = itemMap.containsKey(book.getBookId());

        if(isExist) {
            CartItem cartItem = itemMap.get(book.getBookId());
            int count = cartItem.getCount();
            count++;
            cartItem.setCount(count);
        } else {
            itemMap.put(book.getBookId(), new CartItem(book, 1));
        }
    }

    // 修改某个购物项的数量
    public void updateCartItem(String bookIdStr, String countStr) {
        Integer bookId = Integer.parseInt(bookIdStr);
        int count = Integer.parseInt(countStr);
        CartItem cartItem = itemMap.get(bookId);
        cartItem.setCount(count);
    }

    public void clearCart() {
        itemMap.clear();
    }

    public boolean delItem(String bookIdStr) {
        Integer bookId = Integer.parseInt(bookIdStr);
        itemMap.remove(bookId);
        return itemMap.isEmpty();
    }

    // 总数量
    public int getTotalCount() {
        int count = 0;
        Collection<CartItem> values = itemMap.values();
        for(CartItem cartItem : values) {
            count += cartItem.getCount();
        }
        return count;
    }

    // 总金额
    public double getTotalAmount() {
        double amount = 0;
        Collection<CartItem> values = itemMap.values();
        for(CartItem cartItem : values) {
            amount += cartItem.getAmount();
        }
        return amount;
    }

}