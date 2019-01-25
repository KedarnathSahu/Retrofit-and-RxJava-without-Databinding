package com.cumulations.retrofitandrxjavawithoutdatabinding.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cumulations.retrofitandrxjavawithoutdatabinding.R;
import com.cumulations.retrofitandrxjavawithoutdatabinding.model.Employee;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Employee> arraylist;

    public CustomAdapter(Context context, List<Employee> arraylist) {
        this.arraylist = arraylist;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return arraylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View covertview, ViewGroup parent) {
        View vi = covertview;
        ViewHolder viewHolder;
        if (covertview == null) {
            vi = layoutInflater.inflate(R.layout.innerlayout, null);
            viewHolder = new ViewHolder();
            viewHolder.firstname = (TextView) vi.findViewById(R.id.firstname);
            viewHolder.lastname = (TextView) vi.findViewById(R.id.lastname);
            vi.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) vi.getTag();
        }
        Employee items = (Employee) getItem(pos);
        viewHolder.firstname.setText(items.getFirstName());
        viewHolder.lastname.setText(items.getLastName());
        return vi;
    }

    public static class ViewHolder {
        TextView firstname, lastname;
    }
}
