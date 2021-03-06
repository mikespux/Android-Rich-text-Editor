package com.chinalwb.are.render;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Spanned;
import android.util.AttributeSet;

import com.chinalwb.are.Constants;
import com.chinalwb.are.Util;
import com.chinalwb.are.android.inner.Html;

/**
 * @author dlink
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2018/5/20
 * @discription null
 * @usage null
 */
public class AreTextView extends AppCompatTextView {
    Context mContext;

    public AreTextView(Context context) {
        this(context, null);
    }

    public AreTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AreTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initGlobalValues();
    }

    private void initGlobalValues() {
        int[] wh = Util.getScreenWidthAndHeight(mContext);
        Constants.SCREEN_WIDTH = wh[0];
        Constants.SCREEN_HEIGHT = wh[1];
    }

    public void fromHtml(String html) {
        Html.sContext = mContext;
        Html.ImageGetter imageGetter = new AreImageGetter(mContext, this);
        Html.TagHandler tagHandler = new AreTagHandler();
        Spanned spanned = Html.fromHtml(html, Html.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH, imageGetter, tagHandler);
        setText(spanned);
    }

}
