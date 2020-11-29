package com.a10w.listviewselectors.ui.animation;

import android.view.View;

import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

public class AnimationHelpers {
    public static SpringAnimation createSpringAnimation(View itemView ){
        return new SpringAnimation(itemView, SpringAnimation.TRANSLATION_Y)
                .setSpring(new SpringForce()
                        .setFinalPosition(0f)
                        .setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY)
                        .setStiffness(SpringForce.STIFFNESS_LOW));
    }
}
