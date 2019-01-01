package com.example.admin.finishcourse.lessonEight;
/**
 * @author Thuan Envity
 * @datetime 2018/12/26
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.finishcourse.R;

import java.util.List;

public class LessonEightRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Student> studentList;
    private OnItemListener onItemListener;
    private Context mContext;

    public LessonEightRecyclerViewAdapter(Context mContext, List<Student> studentList) {
        this.mContext = mContext;
        this.studentList = studentList;
    }

    // udpate data when change status
    public void update(List<Student> studentList) {
        this.studentList = studentList;
        // commit change
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_lesson8, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ItemHolder) holder).tvName.setText(studentList.get(position).getName());
        ((ItemHolder) holder).tvClassName.setText(studentList.get(position).getClassName());

        ((ItemHolder) holder).linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemListener != null && studentList != null) {
                    onItemListener.onItemClick(studentList.get(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("Lesson8RecycAdapter","getItemCount");
        return studentList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvClassName;
        private LinearLayout linearLayout;

        public ItemHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvNameLesson8);
            tvClassName = (TextView) itemView.findViewById(R.id.tvClassLesson8);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayoutLesson8);
        }
    }

    public interface OnItemListener {
        void onItemClick(Integer idStudent);
    }

    public void setOnItemListener(OnItemListener listener) {
        this.onItemListener = listener;
    }
}
