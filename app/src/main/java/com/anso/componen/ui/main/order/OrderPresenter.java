package com.anso.componen.ui.main.order;

import android.app.Activity;
import com.anso.base.basemvp.BasePresenter;

/**
 * Created by 开发部 on 2018/2/7.
 */
public class OrderPresenter extends BasePresenter<OrderView> {
    private Activity context;
    private OrderView orderView;

    public OrderPresenter(Activity context) {
        this.context = context;
    }

}
