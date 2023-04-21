package com.example.loginrecyclerview
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivityFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
//        tampilMyFriendsFragment()

        val view_pager : ViewPager = findViewById(R.id.view_pager)
        val tabs : TabLayout = findViewById(R.id.tabs)

        view_pager.adapter = ViewPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(view_pager)
    }

        private fun gantiFragment(fragmentManager: FragmentManager, fragment: Fragment,
                              frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId,fragment)
        transaction.commit()
    }
            fun tampilMyFriendsFragment() {
        gantiFragment(supportFragmentManager,FragmentFirst.newInstance(),R.id.tabs)
    }

            fun tampilMyFriendsAddFragment() {
        gantiFragment(supportFragmentManager,FragmentSecond.newInstance(),R.id.view_pager)
  }
}