package com.phong.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phong.hoclistviewnangcao.R;
import com.phong.model.SanPham;

import java.util.zip.Inflater;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    //Adapter lệ thuộc vào nguồn dữ liệu, nguồn có kiểu gì thì Adapter có kiểu đó
    //Adapter này sẽ lệ thuộc vào Layout nào đó chính là CustomLayout
    /*Context ở đây là các màn hình nào sử dụng nó
    nhưng nên để Activity vì dễ xử lý hơn và thông qua Activity chúng ta truy suất các tài nguyên
    của phần mềm cụ thể là trong các layout, giao diện dễ hơn
     */
    Activity context;
    int resource;
    public SanPhamAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Để nạp fileLayout vào bộ nhớ:
        LayoutInflater inflater = this.context.getLayoutInflater();
        //Nạp item.xml lên:
        View customView = inflater.inflate(this.resource,null);//resource chính là item.xml
        //Lấy các controls trên giao diện:
        ImageView imgHinh = (ImageView) customView.findViewById(R.id.imgHinh);
        TextView txtTen = (TextView) customView.findViewById(R.id.txtTen);
        TextView txtGia = (TextView) customView.findViewById(R.id.txtGia);
        //Nạp dữ liệu lên cho Controls: muốn nạp thì̀ lấy đối tượng ra
        //Đối số 1 của getView là vị trí mà đối tượng đó đang đc nhân bản lên
        SanPham sp = getItem(position);//tư động lấy đối tượng dữ liệu ra ở vị trí thứ position nào đó
        //Show lên:
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        txtGia.setText(sp.getGia() + "VND");
        return customView;
    }
}
