package com.talenguyen.TaleSamples.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Checkable;
import com.talenguyen.TaleSamples.R;

public class ToggleStarButton extends Button implements Checkable {
    private final Drawable mCheckedDrawable;
    private final Drawable mNormalDrawable;
    private boolean mChecked;
    private boolean mBroadcasting;
    private OnCheckedChangeListener mOnCheckedChangeListener;

    public ToggleStarButton(Context context) {
        this(context, null);
    }

    public ToggleStarButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ToggleStarButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mCheckedDrawable = getResources().getDrawable(R.drawable.star_vote);
        mNormalDrawable = getResources().getDrawable(R.drawable.star_vote_over);
    }

    public void toggle() {
        setChecked(!mChecked);
    }

    @Override
    public boolean performClick() {
        /*
         * XXX: These are tiny, need some surrounding 'expanded touch area',
         * which will need to be implemented in Button if we only override
         * performClick()
         */

        /* When clicked, toggle the state */
        toggle();
        return super.performClick();
    }

    public boolean isChecked() {
        return mChecked;
    }

    /**
     * <p>Changes the checked state of this button.</p>
     *
     * @param checked true to check the button, false to uncheck it
     */
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;

            // Avoid infinite recursions if setChecked() is called from a listener
            if (mBroadcasting) {
                return;
            }

            mBroadcasting = true;
            if (mOnCheckedChangeListener != null) {
                mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            }
            mBroadcasting = false;
            refreshDrawable();
        }
    }

    public void refreshDrawable() {
        invalidate();
    }

    /**
     * Register a callback to be invoked when the checked state of this button
     * changes.
     *
     * @param listener the callback to call on checked state change
     */
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }


    /**
     * Interface definition for a callback to be invoked when the checked state
     * of a compound button changed.
     */
    public static interface OnCheckedChangeListener {
        /**
         * Called when the checked state of a compound button has changed.
         *
         * @param buttonView The compound button view whose state has changed.
         * @param isChecked  The new checked state of buttonView.
         */
        void onCheckedChanged(ToggleStarButton buttonView, boolean isChecked);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            performClick();
            return true;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final Drawable buttonDrawable = mChecked ? mCheckedDrawable : mNormalDrawable;
        if (buttonDrawable != null) {
            buttonDrawable.setBounds(0, 0, getWidth(), getHeight());
            buttonDrawable.draw(canvas);
        }
    }

}
