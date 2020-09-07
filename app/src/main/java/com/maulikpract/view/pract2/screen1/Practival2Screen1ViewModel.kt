package com.maulikpract.view.pract2.screen1

import android.view.View
import com.maulikpract.R
import com.maulikpract.base.BaseState
import com.maulikpract.base.BaseViewModel
import com.maulikpract.view.restaurant.ResturantActivityState
import com.maulikpract.databinding.ActivityPractical2Screen1Binding

class Practival2Screen1ViewModel(private val state: Practival2Screen1State) : BaseViewModel() {
    override fun provideState(): BaseState = state

    fun isUserInputValid(): Boolean {
        return if (state.count.value.isNullOrEmpty()) {
            state.validationLiveData.postValue(Practival2Screen1State.ErrorMessage(invalidCount = R.string.enter_valid_number))
            false
        } else {
            state.validationLiveData.postValue(Practival2Screen1State.ErrorMessage(isValid = R.string.is_valid))
            true
        }
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.btnAdd -> {
                state.clickEvent.postValue(ClickEvent.addButtonClicked)
            }
        }
    }
}