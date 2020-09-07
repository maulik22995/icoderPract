package com.maulikpract.view.restaurant.fragment

import android.os.Bundle
import android.view.View
import com.maulikpract.R
import com.maulikpract.adapter.MenuDataAdapter
import com.maulikpract.base.BaseFragment
import com.maulikpract.databinding.MenuListFragmentBinding
import com.maulikpract.model.MenuItemDetail
import com.maulikpract.utils.ITEM_POSITION
import com.maulikpract.utils.listners.OnItemClickListener
import com.maulikpract.view.pract2.screen2.adapter.ButtonsAdapter
import com.maulikpract.view.restaurant.RestaurantActivityViewModel
import com.maulikpract.view.restaurant.ResturantActivityState
import kotlinx.android.synthetic.main.activity_practival2_screen2.*
import kotlinx.android.synthetic.main.menu_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuListFragment :
    BaseFragment<MenuListFragmentBinding, ResturantActivityState, RestaurantActivityViewModel>(R.layout.menu_list_fragment),
    OnItemClickListener {

    private lateinit var adapterMenu: MenuDataAdapter
    private var data: ArrayList<MenuItemDetail> = ArrayList()
    var type: Int = 0

    companion object {
        fun newInstance(param: Int) = MenuListFragment().apply {
            arguments = Bundle().apply {
                putInt(ITEM_POSITION, param)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getBundle(ITEM_POSITION)?.let {
            type = it.getInt(ITEM_POSITION)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setList()
    }

    private fun initView() {
        adapterMenu = MenuDataAdapter(data, this)
        reyMenu.apply {
            adapter = adapterMenu
        }
    }

    private fun setList() {
        viewModel.data?.let {
            data = it.Result[type].menu_item_detail
            adapterMenu.setData(data)
        }
    }

    override val viewModel: RestaurantActivityViewModel by viewModel()

    override fun observeViewState(state: ResturantActivityState) {

    }

    override fun onItemClick(view: View, data: Any, position: Int) {

    }

}