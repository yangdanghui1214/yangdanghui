package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.toolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;

/**
 * Created by lenovo on 2017/3/26.
 */

public class Toolbar_zhuanzhang extends Toolbar {
    //添加布局必不可少的工具
    private LayoutInflater mInflater;

    //标题
    private TextView mTextTitle;
    //左边按钮
    private ImageView mLeftButton;
    //you边按钮
    private TextView mrightButton;

    private View mView;

    //以下是继承ToolBar必须创建的三个构造方法
    public Toolbar_zhuanzhang(Context context) {
        this(context, null);
    }

    public Toolbar_zhuanzhang(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Toolbar_zhuanzhang(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();

        //Set the content insets for this toolbar relative to layout direction.
        setContentInsetsRelative(0, 0);

        if (attrs != null) {
            //读写自定义的属性，如果不会自己写的时候，就看看官方文档是怎么写的哈
            /**
             * 下面是摘自官方文档
             * final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
             R.styleable.Toolbar, defStyleAttr, 0);

             mTitleTextAppearance = a.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
             mSubtitleTextAppearance = a.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
             mGravity = a.getInteger(R.styleable.Toolbar_android_gravity, mGravity);
             mButtonGravity = Gravity.TOP;
             mTitleMarginStart = mTitleMarginEnd = mTitleMarginTop = mTitleMarginBottom =
             a.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, 0);

             final int marginStart = a.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
             if (marginStart >= 0) {
             mTitleMarginStart = marginStart;
             }

             *
             */
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.LetToolBar, defStyleAttr, 0);

            final Drawable leftIcon = a.getDrawable(R.styleable.LetToolBar_leftButtonIcon);
            if (leftIcon != null) {
                setLeftButtonIcon(leftIcon);
            }


            boolean isShowSearchView = a.getBoolean(R.styleable.LetToolBar_isShowSearchView, false);

            //如果要显示searchView的时候
            if (isShowSearchView) {
                hideTitleView();
            }
            //资源的回收
            a.recycle();
        }

    }


    private void initView() {

        if (mView == null) {
            //初始化
            mInflater = LayoutInflater.from(getContext());
            //添加布局文件
            mView = mInflater.inflate(R.layout.toolbar_zhuanzhang, null);

            //绑定控件
            mTextTitle = (TextView) mView.findViewById(R.id.toolbar_title1);
            mLeftButton = (ImageView) mView.findViewById(R.id.title1_back);
            mrightButton = (TextView) mView.findViewById(R.id.title1_right);


            //然后使用LayoutParams把控件添加到子view中
            Toolbar.LayoutParams lp = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView, lp);

        }
    }

    @Override
    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if (mTextTitle != null) {
            mTextTitle.setText(title);
            showTitleView();
        }
    }

    //隐藏标题
    public void hideTitleView() {
        if (mTextTitle != null)
            mTextTitle.setVisibility(GONE);
    }

    //隐藏right的图标
    public void hiderightView() {
        if (mrightButton != null)
            mrightButton.setVisibility(GONE);
    }

    //显示标题
    public void showTitleView() {
        if (mTextTitle != null)
            mTextTitle.setVisibility(VISIBLE);
    }


    //给左侧按钮设置图片，也可以在布局文件中直接引入
    private void setLeftButtonIcon(Drawable icon) {
        if (mLeftButton != null) {
            mLeftButton.setImageDrawable(icon);
            mLeftButton.setVisibility(VISIBLE);
        }
    }


    //设置左侧按钮监听事件
    public void setLeftButtonOnClickLinster(View.OnClickListener linster) {
        mLeftButton.setOnClickListener(linster);
    }

    //设置右侧按钮监听事件
    public void setrightButtonOnClickLinster(View.OnClickListener linster) {
        mrightButton.setOnClickListener(linster);
    }

}