package com.example.returnytalo.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.returnytalo.R;
import com.example.returnytalo.model.Book;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.bookviewholder> {

    List<Book> mdata;

    public BookAdapter(List<Book> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false);

       return new bookviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookviewholder holder, int position) {

        Glide.with(holder.itemView.getContext())
                .load(mdata.get(position).getDrawableResource()) //set the img book Url
                .transform(new CenterCrop(),new RoundedCorners(16))
                .into(holder.imgBook);

        holder.ratingBar.setRating((float)4.5);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    public class bookviewholder extends RecyclerView.ViewHolder{
        ImageView imgBook,imgFav;
        TextView title,author,pages,rate;
        RatingBar ratingBar;

        public bookviewholder(@NonNull View itemView) {
            super(itemView);
            imgBook = itemView.findViewById(R.id.item_book);
            title = itemView.findViewById(R.id.item_book_title);
            author = itemView.findViewById(R.id.item_book_author);
            pages = itemView.findViewById(R.id.item_book_pagesrev);
            rate = itemView.findViewById(R.id.item_book_score);
            ratingBar = itemView.findViewById(R.id.item_book_ratingbar);
        }
    }
}
