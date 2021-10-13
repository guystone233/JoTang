package com.guystone.jotang

import android.animation.ObjectAnimator
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.LinearInterpolator
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.guystone.jotang.ui.main.SectionsPagerAdapter
import com.guystone.jotang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        val am = ObjectAnimator.ofFloat(viewPager,"rotation", 0f, 360f)
        am.duration = 3000
        am.repeatCount = 1
        am.interpolator = AnticipateOvershootInterpolator()
        am.start()

    }
    public fun a(){
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel("normal","Normal",NotificationManager.IMPORTANCE_DEFAULT)
        manager.createNotificationChannel(channel)
        val builder = NotificationCompat.Builder(this,"normal")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("233")
            .setContentText("233")
            manager.notify(1, builder.build())
        }



}