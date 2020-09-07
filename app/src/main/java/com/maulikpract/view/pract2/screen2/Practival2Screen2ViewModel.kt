package com.maulikpract.view.pract2.screen2

import com.maulikpract.base.BaseState
import com.maulikpract.base.BaseViewModel
import com.maulikpract.model.ButtonState
import kotlin.random.Random

class Practival2Screen2ViewModel(private val state: Practival2Screen2State) : BaseViewModel() {
    override fun provideState(): BaseState = state


    fun prepareButtonFirst(total: Int) {
        if(total == 0){
            return
        }
        val data = ArrayList<ButtonState>()
        for (i in 0..total-1) {
            data.add(ButtonState(i, 0))
        }
        data[Random.nextInt(0,total)].buttonState = 1
        state.buttonLiveData.postValue(data)
    }

}