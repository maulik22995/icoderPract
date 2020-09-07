package com.maulikpract.view.restaurant

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.observe
import com.maulikpract.R
import com.maulikpract.base.BaseActivity
import com.maulikpract.databinding.ActivityRestuarentBinding
import com.maulikpract.model.RestaurantData
import com.maulikpract.view.restaurant.fragment.MenuListFragment
import kotlinx.android.synthetic.main.activity_restuarent.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class RestuarentActivity :
    BaseActivity<ActivityRestuarentBinding, ResturantActivityState, RestaurantActivityViewModel>(R.layout.activity_restuarent) {

    lateinit var restResp : RestaurantData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getResturantData()
        initViews()
        initListners()
    }

    private fun initListners() {
    }

    private fun initViews() {
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setUpViewPager() {
        val adapter = ViewPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )

        restResp?.let {
            for (i in restResp.Result.indices){
                adapter.addFrag(
                    MenuListFragment.newInstance(i),restResp.Result[i].menu_name)
            }
        }

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }

    override val viewModel: RestaurantActivityViewModel by viewModel()

    override fun observeViewStat(state: ResturantActivityState) {
        state.resturantAPIState.observe(this){
            when{
                it is RestaurantAPIState.Success ->{
                    restResp = it.data
                    state.coverImageUrl.value = it.data.restaurant_details.icon_image
                    setUpViewPager()
                }
            }
        }
    }


    private class ViewPagerAdapter(fm: FragmentManager, behavior: Int) :
        FragmentPagerAdapter(fm, behavior) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }
}