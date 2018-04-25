package kale.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import kale.injection.SelectorInjection;
import kale.utils.SelectorUtils;

/**
 * @author Kale
 * @date 2016/3/14
 *
 * 支持阴影，不支持check状态
 */
public class SelectorButton extends AppCompatCheckBox implements ISelectorView {

    private SelectorInjection injection;

    public SelectorButton(Context context) {
        this(context, null);
    }

    public SelectorButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.buttonStyle);
    }

    public SelectorButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        injection = SelectorUtils.injectionToTextView(this, attrs, defStyle);

        // TODO: 2018/4/25 描边会复制 
    }

    @Override
    public SelectorInjection initSelectorInjection(Context context, AttributeSet attrs) {
        return new SelectorInjection(context, attrs);
    }

    @Override
    public SelectorInjection getSelectorInjection() {
        return injection;
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
        // FIXME: 2018/4/25 layer-list做背景时会出现padding失效的问题
    }

}
