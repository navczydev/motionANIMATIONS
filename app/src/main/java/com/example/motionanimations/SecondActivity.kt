package com.example.motionanimations

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.core.view.ViewCompat
import androidx.core.view.ViewCompat.setTransitionName
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback

/**
 * @author Nav Singh
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //you can set this property in theme too
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        //transitionName must be same as the value that we pass in options  with intent
        findViewById<View>(android.R.id.content).transitionName = "shared_element_container"

        // Set up shared element transition and disable overlay so views don't show above system bars
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        //container transformation with few custom attributes like speed, color, etc.
        val materialTransform = MaterialContainerTransform(this).apply {
            //root view
            addTarget(android.R.id.content)
            //speed of anim
            duration = 600
            pathMotion = MaterialArcMotion()
            scrimColor = Color.TRANSPARENT
        }

        window.sharedElementEnterTransition = materialTransform

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}