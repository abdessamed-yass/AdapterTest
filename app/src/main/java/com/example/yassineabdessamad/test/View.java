package com.example.yassineabdessamad.test;


import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;


/**
 * Created by lambe on 21/08/2017.
 */

public class View extends ProgressBar {
    public View(Context context) {
        super(context);
        init();
    }

    public View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }

}
