package com.example.returnytalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.returnytalo.model.Book;
import com.example.returnytalo.recyclerview.BookAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBooks;
    private BookAdapter bookAdapter;
    private List<Book> mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initmdataBooks();
        setupBookAdapter();

    }

    private void setupBookAdapter() {
        bookAdapter = new BookAdapter(mdata);
        rvBooks.setAdapter(bookAdapter);
    }

    private void initmdataBooks() {
        mdata = new ArrayList<>();
        mdata.add(new Book(R.drawable.book1));
        mdata.add(new Book(R.drawable.book2));
        mdata.add(new Book(R.drawable.book3));
        mdata.add(new Book(R.drawable.book4));
    }

    private void initViews() {
        rvBooks = findViewById(R.id.rv_book);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        rvBooks.setHasFixedSize(true);
    }
}
