package com.guystone.jotang

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.time.LocalDateTime
import java.util.*
import java.util.Collections.rotate


class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image: ImageView = view.findViewById(R.id.imageView2)
        val am= ObjectAnimator.ofFloat(image,"rotation", 0f, 360f)
        am.duration = 500
        am.repeatCount = -1
        am.interpolator = LinearInterpolator()
        am.start()
        var is_rotating=1
        image.setOnClickListener {
        if(is_rotating==0){
            am.start()
            is_rotating=1
            }
        else {
            am.pause()
            is_rotating=0
        }
        }
        val task = MyTimerTask()
        Timer().schedule(task, Date(), 1000)

    }
    fun txt(){
            val textview: TextView = view?.findViewById(R.id.textView) as TextView
            textview.text=LocalDateTime.now().toString()
    }

}