/*
* Copyright 2020 MediaCentric
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.maulikpract.utils.extension

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.*
import com.maulikpract.R
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Extension function to start/launch new [Activity]
 * @param func is a lambda function with [Intent]'s receiver which provides a lambda block
 * to perform action on to the [Intent] which will be used to start Activity
 * T takes name of the destination [Activity]
 * */
inline fun <reified T : Activity> Activity.navigateTo(func: Intent.() -> Unit = {}) =
    this.startActivity(Intent(this, T::class.java).apply(func))

inline fun <reified T : Activity> Context.navigateTo(func: Intent.() -> Unit = {}) =
    this.startActivity(Intent(this, T::class.java).apply(func))

inline fun <reified T : Activity> Context.pendingnIntent(func: Intent.() -> Unit = {}): Intent {
    return Intent(this, T::class.java).apply(func)
}

/**
 * Extension function to start/launch new [Activity] without passing any data
 * */
inline fun <reified T : Activity> Activity.navigateTo() =
    this.startActivity(Intent(this, T::class.java))

/**
 * Extension function to start/launch new [Activity] without passing any data
 * */
inline fun <reified T : Activity> Activity.navigateToAndFinish() {
    this.apply {
        startActivity(Intent(this, T::class.java))
        finish()
    }
}

inline fun <reified T : Activity> Activity.navigateToAndFinishSetResult() {
    this.apply {
        startActivity(Intent(this, T::class.java))
        setResult(RESULT_OK, intent)
        finish()
    }
}

/**
 * Extension function to start/launch new [Activity]
 * @param func is a lambda function with [Intent]'s receiver which provides a lambda block
 * to perform action on to the [Intent] which will be used to start Activity
 * T takes name of the destination [Activity]
 * It will finish() current activity and navigate to destination activity
 * */
inline fun <reified T : Activity> Activity.navigateToAndFinish(func: Intent.() -> Unit = {}) {
    this.startActivity(Intent(this, T::class.java).apply(func))
    this.finish()
}

/**
 * Extension function to start/launch new [Activity] with passing any data
 * */
inline fun <reified T : Activity> Activity.navigateToWithData(
    key: ArrayList<String>,
    value: List<String>,
    isFinish: Boolean = false
) {
    val intent = Intent(this, T::class.java)
    key.forEachIndexed { index, _ ->
        intent.putExtra(key[index], value[index])
    }
    startActivity(intent)
    if (isFinish) this.finish()
}

/**
 * Extension function to start/launch new [Activity] for result without passing any data
 * */
inline fun <reified T : Activity> Activity.navigateForResultTo(requestCode: Int) =
    this.startActivityForResult(Intent(this, T::class.java), requestCode)

/**
 * Extension function to start/launch new [Activity] for result
 * @param func is a lambda function with [Intent]'s receiver which provides a lambda block
 * to perform action on to the [Intent] which will be used to start Activity
 * */
inline fun <reified T : Activity> Activity.navigateForResultTo(
    requestCode: Int,
    func: Intent.() -> Unit = {}
) =
    this.startActivityForResult(Intent(this, T::class.java).apply(func), requestCode)


inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

/**
 * gets system service and casts it to the requested type else throws [ClassCastException]
 * */
inline fun <reified T> Context.getService(serviceName: String): T? =
    getSystemService(serviceName).let { service ->
        return when (service) {
            is T -> service
            else -> null
        }
    }

/**
 * Extension function to hide keyboard
 **/
fun Activity.hideKeyBoard() {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(
        currentFocus?.windowToken,
        0
    )
}

fun Context.setFragment(
    view: Int,
    fragment: Fragment,
    isAddToBackStack: Boolean,
    requiredAnimation: Boolean,
    supportFragmentManager: FragmentManager
) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.add(view, fragment)
    fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
    fragmentTransaction.commit()
}
