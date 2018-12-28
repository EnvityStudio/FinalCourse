package com.example.admin.finishcourse.lessonSix;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import com.example.admin.finishcourse.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * @author Thuan Envity
 * @date 2018/12/27
 */
public class LessonSixRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Student> studentList;
    private Context mContext;
    private OnItemListener onItemListener;
    public LessonSixRecyclerViewAdapter(Context mContext,List<Student> studentList) {
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
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_lesson6,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((ItemHolder)holder).tvName.setText(studentList.get(position).getName());
        ((ItemHolder)holder).tvStatus.setText(studentList.get(position).getStatus());

        String imageURL = studentList.get(position).getImageUrl();
        int i = R.drawable.a;
        Log.d("LessonSixAdapter i: ", i + "");
        int i2 = mContext.getResources().getIdentifier("a","drawable",mContext.getPackageName());
        Log.d("LessonSixAdapter i2: ", i2 + "");
        Log.d("ImageURL:  ", imageURL);
        Picasso.with(mContext).load(mContext.getResources().getIdentifier(imageURL,"drawable",mContext.getPackageName())).into(((ItemHolder) holder).imageView);
        ((ItemHolder)holder).linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemListener!=null){
                    onItemListener.onItemClick(studentList.get(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvName;
        private TextView tvStatus;
        private LinearLayout linearLayout;


        public ItemHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imgViewLesson6);
            tvName = (TextView) itemView.findViewById(R.id.tvNameLesson6);
            tvStatus= (TextView) itemView.findViewById(R.id.tvStatusLesson6);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.linearLayoutLesson6);
        }
    }
    public interface OnItemListener {
        void onItemClick(String student);
    }

    public void setOnItemListener(OnItemListener listener) {
        this.onItemListener = listener;
    }
}
