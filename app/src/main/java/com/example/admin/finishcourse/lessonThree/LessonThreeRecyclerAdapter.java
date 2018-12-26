package com.example.admin.finishcourse.lessonThree;

/**
 * @author Thuan Envity
 * @datetime 2018/12/26
 */

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.finishcourse.R;

import java.util.List;

public class LessonThreeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Student> studentList;
    private OnItemListener onItemListener;

    public LessonThreeRecyclerAdapter(List<Student> studentList) {

        this.studentList = studentList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create viewholder
        // do somthing
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_lesson3, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        try {
            ((ItemHolder) holder).tvID.setText(studentList.get(position).getId());
            ((ItemHolder) holder).tvName.setText(studentList.get(position).getName());
            ((ItemHolder) holder).linearLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (onItemListener != null) {
                        onItemListener.onItemClick(((ItemHolder) holder).tvID.getText().toString());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView tvID;
        private TextView tvName;
        private LinearLayout linearLayout;

        public ItemHolder(View itemView) {
            super(itemView);
            tvID = (TextView) itemView.findViewById(R.id.tvItemID);
            tvName = (TextView) itemView.findViewById(R.id.tvItemName);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }

    }

    public interface OnItemListener {
        void onItemClick(String student);
    }

    public void setOnItemListener(OnItemListener listener) {
        this.onItemListener = listener;
    }

}
