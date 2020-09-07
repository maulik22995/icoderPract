package com.maulikpract.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.maulikpract.BR
import com.maulikpract.R
import com.maulikpract.databinding.ItemButtonsBinding
import com.maulikpract.model.ButtonState
import com.maulikpract.model.MenuItemDetail
import com.maulikpract.utils.listners.OnItemClickListener


class MenuDataAdapter(
    private val menuData: ArrayList<MenuItemDetail>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<MenuDataAdapter.MenuDataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuDataViewHolder {
        return MenuDataViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_menu, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return menuData.size
    }

    override fun onBindViewHolder(holder: MenuDataViewHolder, position: Int) {
        holder.bind(menuData[position])
        (holder.viewBinding as ItemButtonsBinding).root.setOnClickListener {
            listener.onItemClick(it, menuData[position], position)
        }
    }

    fun setData(newData: ArrayList<MenuItemDetail>) {
        menuData.addAll(newData)
        notifyDataSetChanged()
    }


    class MenuDataViewHolder(val viewBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(menu: MenuItemDetail) {
            viewBinding.setVariable(BR.dataModel, menu)
            viewBinding.executePendingBindings()
        }
    }

    class MyDiffUtilCallBack(
        val oldList: ArrayList<MenuItemDetail>,
        var newList: ArrayList<MenuItemDetail>
    ) :
        DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] === newList[newItemPosition]
        }

    }
}