package com.maulikpract.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.maulikpract.BR

abstract class BaseActivity<BINDING : ViewDataBinding, STATE : BaseState, VIEWMODEL : BaseViewModel>(
    @LayoutRes val layoutId: Int
) : AppCompatActivity() {
    protected abstract val viewModel: VIEWMODEL
    protected val state: STATE by lazy {
        viewModel.provideState() as STATE
    }
    protected lateinit var binding: BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initilizeBinding()
        observeViewStat(state)
    }

    /**
     * initilize databinding
     */
    private fun initilizeBinding() {
        DataBindingUtil.setContentView<BINDING>(this, layoutId)
            .apply {
                binding = this
                lifecycleOwner = this@BaseActivity
                setVariable(BR.viewModel,viewModel)
                setVariable(BR.state,state)
                executePendingBindings()
            }
    }

    abstract fun observeViewStat(state: STATE)

    /**
     * Display Toast
     * @param message String
     * @param duration Int
     */
    fun toast(message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }

    /**
     * Display Toast
     * @param message Int : String resource ID
     */
    fun toast(@StringRes message: Int) {
        toast(getString(message))
    }

}