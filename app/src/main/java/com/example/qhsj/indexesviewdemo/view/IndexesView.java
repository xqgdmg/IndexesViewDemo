package com.example.qhsj.indexesviewdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.qhsj.indexesviewdemo.R;

/**
 * Created by cy on 2016/9/16.
 * 索引布局
 */
public class IndexesView extends RelativeLayout {
    char[] indexChars = {'#', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    View view;
    Context context;

    LinearLayout llChars;
    TextView tvChar;

    OnScrollToListener listener;

    public IndexesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.view_index, this);
        initView();
    }

    int index=-1;

    private void initView() {
        llChars = (LinearLayout) view.findViewById(R.id.ll_chars);
        llChars.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        llChars.setBackgroundResource(R.color.grey_transparent);
                        tvChar.setVisibility(VISIBLE);
                        select(v,event);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        select(v,event);
                        break;
                    case MotionEvent.ACTION_UP:
                        llChars.setBackgroundResource(R.color.transparent);
                        tvChar.setVisibility(GONE);
                        index=-1;
                        break;
                }
                return true;
            }
        });
        tvChar = (TextView) view.findViewById(R.id.tv_char);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0, 1);

        for (int i = 0; i < indexChars.length; i++) {
            TextView tv = new TextView(context);
            tv.setText(indexChars[i] + "");
            tv.setTextColor(getResources().getColor(R.color.text_black_1a));
            tv.setLayoutParams(lp);
            tv.setGravity(Gravity.CENTER);
            llChars.addView(tv);
        }
    }

    void select(View v, MotionEvent event){
        int height = v.getHeight()/indexChars.length;
        int x = (int) (event.getY()/height);
        if (x>=0 && x<indexChars.length && x!=index){
            index=x;
            tvChar.setText(indexChars[index] + "");
            if (listener!=null){
                listener.scrollTo(index, indexChars[index]);
            }
        }
    }


    public void setOnScrollToListener(OnScrollToListener listener){
        this.listener=listener;
    }

    /**
     * 需要列表翻到哪一组
     */
    public interface OnScrollToListener{
        void scrollTo(int index, char indexChar);
    }


}
