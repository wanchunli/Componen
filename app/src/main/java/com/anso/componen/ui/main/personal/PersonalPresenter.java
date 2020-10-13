package com.anso.componen.ui.main.personal;

import android.content.Context;
import com.anso.base.basemvp.BasePresenter;

/**
 * Created by 开发部 on 2018/2/7.
 */
public class PersonalPresenter extends BasePresenter<PersonalView> {
    private Context context;
    private PersonalView personalView;

    public PersonalPresenter(Context context) {
        this.context = context;
    }

}
