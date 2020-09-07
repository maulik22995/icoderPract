package com.maulikpract.view.pract2.screen1

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.observe
import com.maulikpract.R
import com.maulikpract.base.BaseActivity
import com.maulikpract.databinding.ActivityPractical2Screen1Binding
import com.maulikpract.utils.INTENT_COUNT_NUMBER
import com.maulikpract.utils.extension.hideKeyBoard
import com.maulikpract.utils.extension.navigateTo
import com.maulikpract.view.pract2.screen2.Practival2Screen2Activity
import kotlinx.android.synthetic.main.activity_practical2_screen1.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class Practical2Screen1Activity :
    BaseActivity<ActivityPractical2Screen1Binding, Practival2Screen1State, Practival2Screen1ViewModel>(
        R.layout.activity_practical2_screen1
    ) {

    override val viewModel: Practival2Screen1ViewModel by viewModel()

    override fun observeViewStat(state: Practival2Screen1State) {
        state.validationLiveData.observe(this) { errorMessage ->
            errorMessage.run {
                when {
                    invalidCount != 0 -> {
                        Toast.makeText(
                            this@Practical2Screen1Activity,
                            R.string.enter_valid_number,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        hideKeyBoard()
                        navigateTo<Practival2Screen2Activity> {
                            putExtra(INTENT_COUNT_NUMBER, etCount.text.toString().toInt())
                        }
                    }
                }
            }
        }

        state.clickEvent.observe(this) {
            when {
                it is ClickEvent.addButtonClicked -> {
//                    state.count.value = etCount.text.toString()
                    viewModel.isUserInputValid()
                }
            }

        }
    }
}