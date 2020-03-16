package com.example.motionanimations

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Nav Singh
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //you can set this property in theme too
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        // Set up shared element transition
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        //disable overlay so views don't show above system bars
        window.sharedElementsUseOverlay = false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //fab button' click will open the SecondActivity with motion's animation from material design
        fab.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            //set options will help to achieve  the  animation
            //sharedElementName must  be same at all  views  ,  on which animation is enabled
            val options = ActivityOptions.makeSceneTransitionAnimation(this,
                    it,
                    "shared_element_container")
            startActivity(intent, options.toBundle())
        }
    }
}