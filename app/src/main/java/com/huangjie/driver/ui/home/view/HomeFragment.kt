package com.huangjie.driver.ui.home.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import com.huangjie.corelib.base.BaseFragment
import com.huangjie.driver.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by huangjie on 2019/3/5.
 */
class HomeFragment : BaseFragment() {

    override fun setContentView(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /**
     * 初始化View
     */
    private fun initView() {
        val adapter = HomeFragmentPageAdapter(childFragmentManager)
        adapter.addFragment(AndroidFragment(), "Android")
        adapter.addFragment(iOSFragment(), "iOS")
        adapter.addFragment(iOSFragment(), "前端")
        adapter.addFragment(iOSFragment(), "扩展资源")

        mViewPager.adapter = adapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    inner class HomeFragmentPageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        private var fragmentList = ArrayList<Fragment>()
        private var titleList = ArrayList<String>()

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titleList[position]
        }

    }

    override fun loadData() {
    }
}