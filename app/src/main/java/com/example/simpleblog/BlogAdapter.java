package com.example.simpleblog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleblog.Entity.Blogs;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {

    private Context context;
    private List<Blogs> blogsList;

    public BlogAdapter(Context context){
        this.context = context;
    }

    public void setBlogsList(List<Blogs> blogsList){
        this.blogsList = blogsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BlogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.blog_recycler, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogAdapter.ViewHolder holder, int position) {
        Blogs blogs = blogsList.get(position);
        String imageUri = blogs.getCover_photo();
        Picasso.with(context.getApplicationContext()).load(imageUri).into(holder.cover);

        holder.title.setText(this.blogsList.get(position).title);
        holder.cat.setText(this.blogsList.get(position).categories.toString());

    }



    @Override
    public int getItemCount() {
        return this.blogsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, cat;
        ImageView cover;

        public ViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.tvTitle);
            cat = view.findViewById(R.id.tvCat);
            cover = view.findViewById(R.id.tvCoverPhoto);
        }
    }

}
