package com.phong.hoclistviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.phong.adapter.SanPhamAdapter;
import com.phong.model.SanPham;

public class MainActivity extends AppCompatActivity {

    ListView lvSanPham;
    /*
    Không dùng ArrayAdapter trong trường hợp này
    Vì SanPhamAdapter đã kế thừa từ ArrayAdapter rồi
    Do đó dùng luôn SanPhamAdapter mà ko cần khai báo ArrayAdapter nữa
     */
    SanPhamAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        fakeData();
    }
    //Gán dữ liệu:
    private void fakeData() {
        sanPhamAdapter.add(new SanPham(R.drawable.h1,"Hoa 1", 15000));
        sanPhamAdapter.add(new SanPham(R.drawable.h2,"Hoa 2", 25000));
        sanPhamAdapter.add(new SanPham(R.drawable.h3,"Hoa 3", 35000));
        sanPhamAdapter.add(new SanPham(R.drawable.h4,"Hoa 4", 5000));
        sanPhamAdapter.add(new SanPham(R.drawable.h5,"Hoa 5", 6000));
        sanPhamAdapter.add(new SanPham(R.drawable.h6,"Hoa 6", 10000));
        sanPhamAdapter.add(new SanPham(R.drawable.h7,"Hoa 7", 23000));
        sanPhamAdapter.add(new SanPham(R.drawable.h8,"Hoa 8", 12000));
        sanPhamAdapter.add(new SanPham(R.drawable.h9,"Hoa 9", 11000));
        sanPhamAdapter.add(new SanPham(R.drawable.h10,"Hoa 10", 3000));
    }

    private void addEvents() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = sanPhamAdapter.getItem(i);
                Toast.makeText(MainActivity.this, "Bạn chọn: " + sp.getTen(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addControls() {
        lvSanPham = (ListView) findViewById(R.id.lvSanPham);
        /*
        Làm adapter
        Đối số 1 là màn hình sử dụng nó
        Đối số 2 là layout mình làm
         */
        sanPhamAdapter = new SanPhamAdapter(this,R.layout.item);
        //Gán adapter cho ListView:
        lvSanPham.setAdapter(sanPhamAdapter);
        //Gán dữ liệu:
    }
}
