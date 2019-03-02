package lqy.bwie.com.moni3.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import lqy.bwie.com.moni3.DetailsActivity;
import lqy.bwie.com.moni3.R;
import lqy.bwie.com.moni3.bean.ShopCar;

/**
 * author lim
 * email:lim@123.com
 * date 2019/3/2
 * desc:
 */
public class MyShopCarAdapter extends RecyclerView.Adapter<MyShopCarAdapter.MyViewHodel> {
    private ShopCar shopCar;
    private Context context;

    public MyShopCarAdapter(ShopCar shopCar, Context context) {
        this.shopCar = shopCar;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shopcar, viewGroup, false);
        MyViewHodel myViewHodel = new MyViewHodel(view);
        return myViewHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodel myViewHodel, final int i) {
        myViewHodel.name.setText(shopCar.getResult().getMlss().getCommodityList().get(i).getCommodityName());
        myViewHodel.price.setText("￥"+shopCar.getResult().getMlss().getCommodityList().get(i).getPrice());
        myViewHodel.num.setText(shopCar.getResult().getMlss().getCommodityList().get(i).getSaleNum()+"");
        myViewHodel.simple.setImageURI(shopCar.getResult().getMlss().getCommodityList().get(i).getMasterPic());
        myViewHodel.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("id",shopCar.getResult().getMlss().getCommodityList().get(i).getCommodityId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopCar.getResult().getMlss().getCommodityList().size();
    }

    public class MyViewHodel extends RecyclerView.ViewHolder{
        private final CheckBox ck;
        private final SimpleDraweeView simple;
        private final TextView name,price,num,add,del;
        private final LinearLayout ll;

        public MyViewHodel(@NonNull View itemView) {
            super(itemView);
            ck = itemView.findViewById(R.id.ck_item_shopcar);
            simple = itemView.findViewById(R.id.simple_item_shopcar);
            name = itemView.findViewById(R.id.tv_name_item_shopcar);
            price = itemView.findViewById(R.id.tv_price_item_shopcar);
            num = itemView.findViewById(R.id.tv_num_item_shopcar);
            add = itemView.findViewById(R.id.tv_addnum_item_shopcar);
            del = itemView.findViewById(R.id.tv_delnum_item_shopcar);
            ll = itemView.findViewById(R.id.ll_item_shopcar);
        }
    }
}
