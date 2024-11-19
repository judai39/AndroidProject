package com.haoyudu.dataadaptertest.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.haoyudu.dataadaptertest.R;
import com.haoyudu.dataadaptertest.word.Word;

import java.util.ArrayList;
import java.util.List;

/**adapter类拥有动态的显示,隐藏当前视图的功能,可以与其他观察者联动,在观察者中引入adapter后调用notifyDataChanged()*/
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.MyViewHolder>/**自行传入泛型约束,以便于自动化构建代码*/{
    List<Word> allWords=new ArrayList<>();

    public void setAllWords(List<Word> allWords) {
        this.allWords = allWords;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        /**注意word_cell_normal中的item的外层布局高度(宽度,如果涉及到宽度约束问题)不能设置成match_parent
         * 否则所有的视图缓存都会堆积到一个固定的地方*/
        View itemView=layoutInflater.inflate(R.layout.word_cell_normal,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Word word=allWords.get(position);
        holder.id.setText(String.valueOf(position+1));
        holder.word.setText(word.getWord());
        holder.meaning.setText(word.getMeaning());
    }

    @Override
    public int getItemCount() {
        /**返回布局元素数量的尺寸*/
        return allWords.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id,word,meaning;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.cell_word_id);
            word=itemView.findViewById(R.id.cell_word_text);
            meaning= itemView.findViewById(R.id.cell_word_meaning);
        }
    }
}
