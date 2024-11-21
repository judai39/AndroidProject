package com.haoyudu.pagingdatastandard.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.haoyudu.pagingdatastandard.R;
import com.haoyudu.pagingdatastandard.student.Student;
import org.jetbrains.annotations.NotNull;

public class MyPagedAdapter extends PagedListAdapter<Student, MyPagedAdapter.MyViewHolder> {


    public MyPagedAdapter(){
        super(new DiffUtil.ItemCallback<Student>() {
            @Override
            public boolean areItemsTheSame(@NonNull @NotNull Student oldItem, @NonNull @NotNull Student newItem) {
                return oldItem.getStudentId()==newItem.getStudentId();
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull @NotNull Student oldItem, @NonNull @NotNull Student newItem) {
                return oldItem.getStudentNumber() == newItem.getStudentNumber();
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cell_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        Student student=getItem(position);
        if (student==null){
            /**分页查询,编译完成后容器中拥有编译对象,但实例对象没有全部加载,仅加载分页查询中指定的pageSize的数据,其他
             * 未加载数据将会显示如下内容*/
            holder.textView.setText("student==null");
        }else{
            holder.textView.setText(String.valueOf(student.getStudentNumber()));
        }

    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.cell_text_id);
        }
    }
}
