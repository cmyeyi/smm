package com.can.mz.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.can.mz.R;
import com.can.mz.utils.ImageLoadUtils;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public interface OnRecyclerViewItemClickListener {
        void onItemClickListener(View v, int position);

    }

    private ArrayList<String> dataList = new ArrayList<>();
    private OnRecyclerViewItemClickListener mItemClickListener;

    public PhotoAdapter(OnRecyclerViewItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void replaceAll(ArrayList<String> list) {
        dataList.clear();
        if (list != null && list.size() > 0) {
            dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_one, parent, false);
        OneViewHolder viewHolder = new OneViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }


    private class OneViewHolder extends BaseViewHolder {
        private ImageView ivImage;

        public OneViewHolder(View view) {
            super(view);
            ivImage = (ImageView) view.findViewById(R.id.ivImage);
            int width = ((Activity) ivImage.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams params = ivImage.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            params.width = width / 3;
            params.height = params.width * 4 / 3;
            ivImage.setLayoutParams(params);
        }

        @Override
        void setData(final int position) {
            String dataStr = dataList.get(position);
            if (!TextUtils.isEmpty(dataStr)) {
                ImageLoadUtils.bindImage(itemView.getContext(), ivImage, dataStr);
            }

            ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClickListener(ivImage, position);
                }
            });
        }
    }
}