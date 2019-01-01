package com.example.admin.finishcourse.lessonSeven;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.finishcourse.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LessonSevenRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Student> studentList;
    private Context mContext;
    private OnItemListener onItemListener;
    public LessonSevenRecyclerViewAdapter(Context mContext,List<Student> studentList){
        this.mContext = mContext;
        this.studentList = studentList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_lesson7,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ItemHolder)holder).tvName.setText(studentList.get(position).getName());
        ((ItemHolder)holder).tvStatus.setText(studentList.get(position).getStatus());
        String  nameImage = studentList.get(position).getImageUrl();
        Picasso.with(mContext).load(Constants.LOCALHOST +"/" +nameImage).into(((ItemHolder)holder).imageView);
        ((ItemHolder)holder).linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemListener!=null){
                    onItemListener.onItemClick(studentList.get(position).getId());
                }
            }
        });
    }
    public class ItemHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvName;
        private TextView tvStatus;
        private LinearLayout linearLayout;
        public ItemHolder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imgViewLesson7);
            tvName = (TextView) itemView.findViewById(R.id.tvNameLesson7);
            tvStatus = (TextView) itemView.findViewById(R.id.tvStatusLesson7);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayoutLesson7);
        }
    }
    @Override
    public int getItemCount() {
        return studentList.size();
    }
    public interface OnItemListener{
        void onItemClick(String idStudent);
    }
    public void setOnItemListener(OnItemListener listener){
        this.onItemListener = listener;
    }
}
