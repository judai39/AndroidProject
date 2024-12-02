package com.haoyudu.kotlindatabase

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var wordsAll= listOf<Word>()

    fun getWordsAll():List<Word>{
        return wordsAll
    }

    fun setWordsAll(allWords:List<Word>){
        this.wordsAll=allWords
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater:LayoutInflater= LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.cell_card,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var word:Word= wordsAll[position]
        holder.text_id.text=word.id.toString()
        holder.english_text.text=word.name
        holder.chinese_text.text=word.meaning
        holder.itemView.setOnClickListener{
            val uri = Uri.parse("https://www.youdao.com/m/result?word=" + holder.english_text.text + "&lang=en")
            var intent=Intent()
            intent.data=uri
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return wordsAll.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        TextView text_id,chinese_text,english_text;
        val text_id: TextView =itemView.findViewById(R.id.text_id)
        val chinese_text:TextView=itemView.findViewById(R.id.chinese_text)
        val english_text:TextView=itemView.findViewById(R.id.english_text)
    }
}