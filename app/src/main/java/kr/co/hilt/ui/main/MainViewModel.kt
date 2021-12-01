package kr.co.hilt.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.reflect.KProperty

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    var name: MutableLiveData<String>? = null
        get() = name
        set(value) {
            field = value
        }
}