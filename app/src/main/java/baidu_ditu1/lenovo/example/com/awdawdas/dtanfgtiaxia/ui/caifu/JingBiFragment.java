package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.caifu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class JingBiFragment extends Fragment {


    private View view;


    public static JingBiFragment newiniter() {
        JingBiFragment jiFenFragment=new JingBiFragment();
        return jiFenFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_jing_bi, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    @OnClick({R.id.caifu_button_jingbi_chongzhi,R.id.caifu_button_jingbi_yue})
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.caifu_button_jingbi_chongzhi:
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",347);
                intent.putExtra("cc","充值");
                startActivity(intent);
                break;
            case R.id.caifu_button_jingbi_yue:
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",287);
                intent.putExtra("cc","余额");
                startActivity(intent);
                break;
        }
    }
}
