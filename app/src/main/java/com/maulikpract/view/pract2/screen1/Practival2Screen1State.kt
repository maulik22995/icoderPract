package com.maulikpract.view.pract2.screen1

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import com.maulikpract.base.BaseState

class Practival2Screen1State : BaseState{

    var count = MutableLiveData<String>()

    val validationLiveData = MutableLiveData<ErrorMessage>()
    val clickEvent = MutableLiveData<ClickEvent>()
    data class ErrorMessage(@StringRes val invalidCount: Int = 0,@StringRes val isValid: Int = 0)

}

/**
 * SignIn api State
 */
sealed class ClickEvent {
    object addButtonClicked : ClickEvent()
}