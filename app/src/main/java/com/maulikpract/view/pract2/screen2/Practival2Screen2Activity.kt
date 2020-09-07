package com.maulikpract.view.pract2.screen2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.maulikpract.R
import com.maulikpract.base.BaseActivity
import com.maulikpract.databinding.ActivityPractival2Screen2Binding
import com.maulikpract.model.ButtonState
import com.maulikpract.utils.INTENT_COUNT_NUMBER
import com.maulikpract.utils.listners.OnItemClickListener
import com.maulikpract.view.pract2.screen2.adapter.ButtonsAdapter
import kotlinx.android.synthetic.main.activity_practival2_screen2.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class Practival2Screen2Activity :
    BaseActivity<ActivityPractival2Screen2Binding, Practival2Screen2State, Practival2Screen2ViewModel>(
        R.layout.activity_practival2_screen2
    ), OnItemClickListener {

    private lateinit var buttonsAdapter: ButtonsAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private var data: ArrayList<ButtonState> = ArrayList()
    private var intTotalCount = 0
    override val viewModel: Practival2Screen2ViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.getInt(INTENT_COUNT_NUMBER)?.let { count ->
            intTotalCount = count
        }
        initViews()
        viewModel.prepareButtonFirst(intTotalCount)
    }

    private fun initViews() {
        gridLayoutManager = GridLayoutManager(this, 4)
        buttonsAdapter = ButtonsAdapter(data, this)
        reyButtons.apply {
            layoutManager = gridLayoutManager
            adapter = buttonsAdapter
        }
    }

    override fun observeViewStat(state: Practival2Screen2State) {
        state.buttonLiveData.observe(this) {
            Log.d(">>", "observed")
            data = it
            buttonsAdapter.setData(it)
        }
    }

    override fun onItemClick(view: View, data: Any, position: Int) {
        when (view.id) {
            R.id.root -> {
                val buttonData = data as ButtonState
                updateButtons(buttonData, position)
            }
        }
    }

    private fun updateButtons(buttonData: ButtonState, position: Int) {
        if (buttonData.buttonState == 1) {
            //red
            data[position].buttonState = 2
            buttonsAdapter.notifyItemChanged(position)
            // do other random blue
            val allRed = data.filter { it.buttonState == 2 }
            if(allRed.size != data.size){ // all already red
                var indexState = data[Random.nextInt(0, data.size)]
                while (allRed.contains(indexState) ){
                    indexState = data[Random.nextInt(0, data.size)]
                }
                data.filter {
                    it.buttonId == indexState.buttonId
                }.map { it.buttonState = 1 }
                buttonsAdapter.notifyDataSetChanged()
            }

        }
    }
}