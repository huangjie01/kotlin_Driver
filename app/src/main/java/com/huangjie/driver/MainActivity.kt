package com.huangjie.driver

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.widget.RadioGroup
import com.huangjie.corelib.base.BaseActivity
import com.huangjie.driver.ui.home.view.HomeFragment
import com.huangjie.driver.ui.movie.view.MovieFragment
import com.huangjie.driver.ui.weather.view.VideoFragment
import com.huangjie.driver.ui.welfare.view.WelfareFragmemt
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_activity_main_content.*

class MainActivity : BaseActivity() {

    var mSelectID: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolBar()
        setViewPager()
        initEvent()
    }


    private fun setToolBar() {
        setSupportActionBar(mToolBar)
        val actionBar = supportActionBar
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        val toggle = ActionBarDrawerToggle(this, mDrawerLayout,
                mToolBar, R.string.drawer_open, R.string.drawer_close)
        mDrawerLayout.addDrawerListener(toggle)
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * 设置ViewPager
     */
    private fun setViewPager() {
        val adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment())
        adapter.addFragment(WelfareFragmemt())
        adapter.addFragment(VideoFragment())
        adapter.addFragment(MovieFragment())
        mViewPager.adapter = adapter
    }

    /**
     * 主界面ViewPagerAdapter
     */
    inner class MainViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        private var fragmentList = ArrayList<Fragment>()

        fun addFragment(fragment: Fragment) {
            fragmentList.add(fragment)
        }

        override fun getItem(position: Int): Fragment {
            Log.e("MainViewPagerAdapter", " getItem  $position ")
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }
    }

    /**
     * 处理事件
     */
    private fun initEvent() {

        mNavigation.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {

            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                if (checkedId == mSelectID) {
                    return
                }
                mSelectID = checkedId

                changeIcon(checkedId)
                when (checkedId) {
                    R.id.navHome -> {
                        mViewPager.currentItem = 0
                    }
                    R.id.navWelfare -> {
                        mViewPager.currentItem = 1

                    }
                    R.id.navVideo -> {
                        mViewPager.currentItem = 2

                    }
                    R.id.navMovie -> {
                        mViewPager.currentItem = 3

                    }

                }
            }
        })
        mNavigation.check(R.id.navHome)
    }

    /**
     * 切换Navigation 图标
     */
    private fun changeIcon(checkedId: Int) {

        navHome.drawableTop = loadDrawable(R.drawable.home_normal)
        navHome.setTextColor(loadColor(R.color.text_color))

        navWelfare.drawableTop = loadDrawable(R.drawable.welfare_normal)
        navWelfare.setTextColor(loadColor(R.color.text_color))

        navMovie.drawableTop = loadDrawable(R.drawable.movie_normal)
        navMovie.setTextColor(loadColor(R.color.text_color))

        navVideo.drawableTop = loadDrawable(R.drawable.weather_normal)
        navVideo.setTextColor(loadColor(R.color.text_color))


        when (checkedId) {
            R.id.navHome -> {
                navHome.drawableTop = loadDrawable(R.drawable.home_select)
                navHome.setTextColor(loadColor(R.color.main_color))
            }
            R.id.navWelfare -> {
                navWelfare.drawableTop = loadDrawable(R.drawable.welfare_select)
                navWelfare.setTextColor(loadColor(R.color.main_color))

            }
            R.id.navMovie -> {
                navMovie.drawableTop = loadDrawable(R.drawable.movie_select)
                navMovie.setTextColor(loadColor(R.color.main_color))
            }
            R.id.navVideo -> {
                navVideo.drawableTop = loadDrawable(R.drawable.weather_select)
                navVideo.setTextColor(loadColor(R.color.main_color))

            }
        }
    }
}
