package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.popupWindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;

/**]
 * 自定义 PopupWindow  从底部显示
 * Created by lenovo on 2017/4/13.
 */

public class SelectPicPopupWindow extends PopupWindow {

    private Button btn_take_photo, btn_pick_photo, btn_cancel;
    private View mMenuView;

    public SelectPicPopupWindow(Activity context, View.OnClickListener itemsOnClick) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.cela, null);
        btn_take_photo = (Button) mMenuView.findViewById(R.id.cela_button_zhaoxiang);
        btn_pick_photo = (Button) mMenuView.findViewById(R.id.cela_button_xiangce);
        btn_cancel = (Button) mMenuView.findViewById(R.id.cela_button_puxiao);

        //设置按钮监听
        btn_pick_photo.setOnClickListener(itemsOnClick);
        btn_take_photo.setOnClickListener(itemsOnClick);
        btn_cancel.setOnClickListener(itemsOnClick);
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.take_photo_anim);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y=(int) event.getY();
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(y<height){
                        dismiss();
                    }
                }
                return true;
            }
        });

    }

}
