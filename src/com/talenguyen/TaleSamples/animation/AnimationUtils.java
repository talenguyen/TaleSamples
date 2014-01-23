package com.talenguyen.TaleSamples.animation;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

/**
 * Created by TALE on 1/17/14.
 */
public class AnimationUtils {

    private Interpolator accelerator = new AccelerateInterpolator();
    private Interpolator decelerator = new DecelerateInterpolator();

    private void flipCardRightToLeft(final ImageView cardView, long duration, final AnimatorListenerAdapter listener) {
        final ObjectAnimator halfFirst = ObjectAnimator.ofFloat(cardView, "rotationY", 0f, -90f);
        halfFirst.setDuration(duration);
        halfFirst.setInterpolator(accelerator);
        final ObjectAnimator halfEnd = ObjectAnimator.ofFloat(cardView, "rotationY",
                90f, 0f);
        halfEnd.setDuration(duration);
        halfEnd.setInterpolator(decelerator);
        halfEnd.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                listener.onAnimationEnd(animation);
            }
        });
        halfFirst.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                listener.onAnimationStart(animation);
            }

            @Override
            public void onAnimationEnd(Animator anim) {
                super.onAnimationEnd(anim);
                halfEnd.start();
            }
        });
        halfFirst.start();
    }

    private void flipCardLeftToRight(final ImageView cardView, long duration, final AnimatorListenerAdapter listener) {
        final ObjectAnimator halfFirst = ObjectAnimator.ofFloat(cardView, "rotationY", 0f, 90f);
        halfFirst.setDuration(duration);
        halfFirst.setInterpolator(accelerator);
        final ObjectAnimator halfEnd = ObjectAnimator.ofFloat(cardView, "rotationY", -90f, 0f);
        halfEnd.setDuration(duration);
        halfEnd.setInterpolator(decelerator);
        halfEnd.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animator) {
                super.onAnimationStart(animator);
                listener.onAnimationEnd(animator);
            }

        });
        halfFirst.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                listener.onAnimationStart(animator);
            }

            @Override
            public void onAnimationEnd(Animator anim) {
                super.onAnimationEnd(anim);
                halfEnd.start();
            }
        });
        halfFirst.start();
    }

    private void animateDisappearView(final View view, long duration) {

        // Bring this view to front.
        view.bringToFront();

        // Translate x position.
        final ObjectAnimator animX = ObjectAnimator.ofFloat(view, "x", view.getLeft(), -view.getRight());

        // Translate y position.
        final ObjectAnimator animY = ObjectAnimator.ofFloat(view, "y", view.getTop(), -view.getBottom());

        // Use animator set to play both animator together.
        final AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.playTogether(animX, animY);
        animSetXY.setDuration(duration);
        animSetXY.setInterpolator(accelerator);
        animSetXY.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });
        animSetXY.start();
    }

}
