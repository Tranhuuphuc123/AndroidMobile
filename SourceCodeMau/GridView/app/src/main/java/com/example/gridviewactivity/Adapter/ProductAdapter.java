package com.example.gridviewactivity.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gridviewactivity.CustomGridViewActivity;
import com.example.gridviewactivity.R;
import com.example.gridviewactivity.model.Products;

import java.util.ArrayList;

/*Xử ly sự kiện cho class Product chủ yếu lwp Adapter giải quyết các cách dổ dữ liệu cho Grid, list, recycleView*/
public class ProductAdapter extends BaseAdapter {
    ArrayList<Products> listProduct;
    Context context; // lớp context đại diện cho lk với class CustomGridViewActivity

    public ProductAdapter(Context context, ArrayList<Products> listProduct) {
        super();
        this.listProduct = listProduct;
        this.context = context;
    }

    @Override
    public int getCount(){
        // trả về tổng số phần tử của ListView
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        // trả về dữ liệu ở từng vị trí position của Adapter, tương ứng các item có trong listProduct
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        // trả về một id tương ứng của mỗi phần tử tương ứng trong listProduct
        return listProduct.get(position).getProductID();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        /*hàm này có ý nghĩa: xử lý nếu View !=null có tồn tại view sẽ đc tái sử dụng còn
        * chỉ ần update mới thui, nếu null thì tạo mới*/
       View viewProduct;
       if(view == null){
           viewProduct = View.inflate(viewGroup.getContext(), R.layout.card_item_gridview, null);
       }else{
           viewProduct = view;
       }

       // bind dữ liệu vào view tức dữ liệu giả ấy
        Products products = (Products) getItem(position);
        ((ImageView)viewProduct.findViewById(R.id.img_product)).setImageResource(products.getImage());
        ((TextView)viewProduct.findViewById(R.id.txtViewID)).setText(products.getProductID() + " ");
        ((TextView)viewProduct.findViewById(R.id.txtNameID)).setText(products.getName() + " ");
        ((TextView)viewProduct.findViewById(R.id.txtPriceDetails)).setText(products.getPrice() + " ");

        return  viewProduct;
    }
}
