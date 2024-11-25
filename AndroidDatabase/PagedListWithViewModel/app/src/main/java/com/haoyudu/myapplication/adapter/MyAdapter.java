package com.haoyudu.myapplication.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.haoyudu.myapplication.R;
import com.haoyudu.myapplication.student.Student;
import org.jetbrains.annotations.NotNull;


public class MyAdapter extends PagedListAdapter<Student,MyAdapter.MyViewHolder> {

    //维护着一个目标类的列表

    public MyAdapter(){
        super(new DiffUtil.ItemCallback<Student>() {
            @Override
            public boolean areItemsTheSame(@NonNull @NotNull Student oldItem, @NonNull @NotNull Student newItem) {
                return oldItem.getId()==newItem.getId();
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull @NotNull Student oldItem, @NonNull @NotNull Student newItem) {
                return oldItem.getNum()==newItem.getNum();
            }
        });
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_normal,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        Student student=students.get(position);
//        holder.student_id.setText(String.valueOf(position+1));
//        holder.student_num.setText(String.valueOf(student.getNum()));
        Student student=getItem(position);
        if (student==null){
            holder.student_id.setText("null_id");
            holder.student_num.setText("null_num");
        }else{
            holder.student_id.setText(String.valueOf(position+1));
            holder.student_num.setText(String.valueOf(student.getNum()));
        }
    }

//    @Override
//    public int getItemCount() {
//        return students.size();
//    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView student_id,student_num;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            student_id=itemView.findViewById(R.id.student_Id);
            student_num=itemView.findViewById(R.id.student_num);
        }
    }
}
