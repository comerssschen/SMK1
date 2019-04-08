package com.weipan.smk1.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.weipan.smk1.R;
import com.weipan.smk1.activity.MainActivity;
import com.weipan.smk1.util.CountDownConfrimHelper;
import com.weipan.smk1.util.CountDownHelper;


/**
 * 作者：create by comersss on 2019/4/4 15:38
 * 邮箱：904359289@qq.com
 */
public class CloseConfirmDialog extends Dialog {

    private final Activity context;

    private OnCloseOrderLitener onCloseOrderLitener;
    public CountDownConfrimHelper helper;
    private TextView tvClose;

    public interface OnCloseOrderLitener {
        void close();
    }

    public void setOnCloseOrderLitener(OnCloseOrderLitener litener) {
        this.onCloseOrderLitener = litener;
    }

    public CloseConfirmDialog(Activity context) {
        super(context);
        this.context = context;
    }

    @Override
    public void show() {
        super.show();
        if (!ObjectUtils.isEmpty(helper)) {
            helper.stop();
            helper = null;
        }
        helper = new CountDownConfrimHelper(tvClose, 10, 1);
        helper.setOnFinishListener(new CountDownConfrimHelper.OnFinishListener() {
            @Override
            public void fin() {
                if (!ObjectUtils.isEmpty(onCloseOrderLitener)) {
                    if (!ObjectUtils.isEmpty(helper)) {
                        helper.stop();
                    }
                    helper = null;
                    if (!(ActivityUtils.getTopActivity() instanceof MainActivity)) {
                        return;
                    }
                    dismiss();
                    onCloseOrderLitener.close();
                }

            }
        });
        helper.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.close_confirm_dialog);

        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        Display display = context.getWindowManager().getDefaultDisplay();
        lp.width = (int) (display.getWidth() * 0.9); // 宽度
        dialogWindow.setAttributes(lp);

        setCancelable(false);
        setCanceledOnTouchOutside(false);

        tvClose = findViewById(R.id.tv_close);
        TextView tvCotinue = findViewById(R.id.tv_cotinue);
//        helper = new CountDownConfrimHelper(tvClose, 10, 1);
//        helper.setOnFinishListener(new CountDownConfrimHelper.OnFinishListener() {
//            @Override
//            public void fin() {
//                if (!ObjectUtils.isEmpty(onCloseOrderLitener)) {
//                    if (!ObjectUtils.isEmpty(helper)) {
//                        helper.stop();
//                    }
//                    helper = null;
//                    dismiss();
//                    onCloseOrderLitener.close();
//                }
//
//            }
//        });
//        helper.start();
        tvClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!ObjectUtils.isEmpty(onCloseOrderLitener)) {
                    if (!ObjectUtils.isEmpty(helper)) {
                        helper.stop();
                    }
                    helper = null;
                    dismiss();
                    onCloseOrderLitener.close();
                }

            }
        });
        tvCotinue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!ObjectUtils.isEmpty(helper)) {
                    helper.stop();
                }
                helper = null;
                dismiss();
            }
        });


    }


}
