package com.haoyudu.roomdatabaseupgrade;

import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    /**没有构造器,也没有对wordsAll添加数据,仅设置了setter,getter,说明要在main中手动添加
     * -->自然想到了observer中添加  思考:为什么observer可以实现自动化观察?
     * -->  observer观察到(这里的观察是?)Model.LiveData变化->调用setWordsAll(),添加了数据到adapter中实现了view的同步
     *                    这里的观察是通过比较adapter中的getCountItem():returnNum,由于之前的观察导致adapter中的数据发生变化,所以这里的returnNum肯定也会变化,所以就能"察觉到"
     * */

    private List<Word> wordsAll=new ArrayList<>();
    private boolean isCard;

    public void setWordsAll(List<Word> wordsAll){
        this.wordsAll=wordsAll;
    }

    public void setCardMode(boolean isCard){
        this.isCard=isCard;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view;
        if(isCard){
            view=inflater.inflate(R.layout.cell_card,parent,false);
        }else{
            view=inflater.inflate(R.layout.cell_normal,parent,false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position/*当前列表位置*/) {
        Word word=wordsAll.get(position);
        holder.text_id.setText(String.valueOf(position+1));
        holder.english_text.setText(word.getName());
        holder.chinese_text.setText(word.getMeaning());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.youdao.com/m/result?word="+holder.english_text.getText()+"&lang=en");
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wordsAll.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text_id,chinese_text,english_text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_id=itemView.findViewById(R.id.text_id);
            chinese_text=itemView.findViewById(R.id.chinese_text);
            english_text=itemView.findViewById(R.id.english_text);
        }
    }

}
