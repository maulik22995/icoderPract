package com.maulikpract.view.pract2.screen2

import androidx.lifecycle.MutableLiveData
import com.maulikpract.base.BaseState
import com.maulikpract.model.ButtonState

class Practival2Screen2State : BaseState {
     val buttonLiveData: MutableLiveData<ArrayList<ButtonState>> = MutableLiveData()

}