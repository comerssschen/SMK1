package com.weipan.smk1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.weipan.smk1.R;
import com.weipan.smk1.common.BaseActivity;
import com.weipan.smk1.view.KeyBoardDialogView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：create by comersss on 2019/4/3 09:01
 * 邮箱：904359289@qq.com
 */
public class StartActivity extends BaseActivity {
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.tv_no_member)
    ImageView tvNoMember;
    @BindView(R.id.tv_member)
    ImageView tvMember;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.iv_setting, R.id.tv_no_member, R.id.tv_member})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_setting:
                Intent intent = new Intent(StartActivity.this, MoreActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_no_member:
                startActivity("");
                break;
            case R.id.tv_member:
                KeyBoardDialogView keyBoardDialogView = new KeyBoardDialogView(StartActivity.this);
                keyBoardDialogView.show();
                keyBoardDialogView.setOnConfirmLitener(new KeyBoardDialogView.onConfirmLitener() {
                    @Override
                    public void confirm(String msg) {
                        ToastUtils.showShort("会员登录成功！");
                        startActivity(msg);
                        keyBoardDialogView.dismiss();
                    }
                });
                break;
            default:
                break;
        }
    }

    private void startActivity(String memberNum) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        intent.putExtra("memberNum", memberNum);
        startActivity(intent);

    }
}
