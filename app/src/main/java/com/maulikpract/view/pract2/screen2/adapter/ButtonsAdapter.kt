package com.maulikpract.view.pract2.screen2.adapter

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
import com.maulikpract.utils.listners.OnItemClickListener


class ButtonsAdapter(
    private val newButtons: ArrayList<ButtonState>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<ButtonsAdapter.ButtonsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonsViewHolder {
        return ButtonsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_buttons, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return newButtons.size
    }

    override fun onBindViewHolder(holder: ButtonsViewHolder, position: Int) {
        holder.bind(newButtons[position])
        (holder.viewBinding as ItemButtonsBinding).root.setOnClickListener {
            listener.onItemClick(it, newButtons[position], position)
        }
    }

    fun setData(newData: ArrayList<ButtonState>) {
        newButtons.clear()
        newButtons.addAll(newData)
        notifyDataSetChanged()
    }


    class ButtonsViewHolder(val viewBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(buttonState: ButtonState) {
            viewBinding.setVariable(BR.dataModel, buttonState)
            viewBinding.executePendingBindings()
        }
    }

    class MyDiffUtilCallBack(
        val oldList: ArrayList<ButtonState>,
        var newList: ArrayList<ButtonState>
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