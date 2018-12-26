package com.example.seifeldenehab.news;

import android.content.Context;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seifeldenehab.news.Json.Article;
import com.example.seifeldenehab.news.Json.DataSet;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    Context mContext;


    List<Article>listOfArticle;
    public Adapter(Context context,List<Article>listOfArticle)
    {
        this.listOfArticle=listOfArticle;
        mContext=context;

        Log.e("error","commit");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder,  int i ) {
        final Article item=listOfArticle.get(i);
        final String author = item.getAuthor();
        final String title = item.getTitle();
        final String des = item.getDescription();
        final String content =item.getContent() ;
        final String img =item.getUrlToImage();
        viewHolder.author.setText(author);
        viewHolder.title.setText(title);
        viewHolder.des.setText(des);
        Picasso.get().load(img).into(viewHolder.urlImg);

        final Intent intent = new Intent (mContext,Main2Activity.class);

        intent.putExtra("title",title );
        intent.putExtra("content",content );
        intent.putExtra("img",img );

        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mContext.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        if(listOfArticle==null)
            return 0;
        return listOfArticle.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,author;
        ImageView urlImg;
        View parent;
        TextView des;
        View card;


        public ViewHolder(View view)
        {
            super(view);
            parent=view;
            urlImg=view.findViewById(R.id.img);
            title=view.findViewById(R.id.title);
            author=view.findViewById(R.id.author);
            des=view.findViewById(R.id.des);
            card = view.findViewById(R.id.card);

        }
    }

}










