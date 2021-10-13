package com.guystone.jotang

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import java.time.LocalDateTime
import java.util.*


public class MyTimerTask() : TimerTask() {
    override fun run() {
        println(LocalDateTime.now().toString())//这里本来应该是修改fragment2中的文本的
    }

}