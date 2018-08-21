package com.can.mz.adapter;

import android.widget.BaseAdapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class CustomBaseAdapter<T> extends BaseAdapter {

	public List<T> list;
	public Set<Integer> pIdSet;
	public CustomBaseAdapter() {
		super();
		if(pIdSet == null) {
			pIdSet = new HashSet<>();
		} else {
			pIdSet.clear();
		}
	}

	@Override
	public int getCount() {
		if (list != null && list.size() > 0)
			return list.size();
		return 0;
	}

	@Override
	public T getItem(int position) {
		if (list == null || position < 0 || position >= list.size()) {
			return null;
		}
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void setDatas(List<T> datas) {
		if(pIdSet != null) {
			pIdSet.clear();
		}
		if(null == list){
			list = datas;
		}else {
			list.clear();
			if(null != datas){
				list.addAll(datas);
			}
		}
		notifyDataSetChanged();
	}

	public void appendData(List<T> datas){
		if(list != null){
			list.addAll(datas);
			notifyDataSetChanged();
		}else{
			setDatas(datas);
		}
	}

	public List<T> getDatas() {
		return list;
	}

	public void clear() {
		if (list != null) {
			list.clear();
			notifyDataSetChanged();
		}
		if(pIdSet != null) {
			pIdSet.clear();
		}
	}

	public void addDataAtFront(T data){
		if(list != null && null != data){
			list.add(0,data);
			notifyDataSetChanged();
		}
	}
}
