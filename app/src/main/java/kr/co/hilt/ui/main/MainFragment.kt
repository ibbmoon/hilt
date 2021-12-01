package kr.co.hilt.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import kr.co.hilt.R
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {
    var TAG = javaClass.simpleName

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.name.value = "kp"
        Log.e(TAG, viewModel.name.value as String);
        // TODO: Use the ViewModel
    }

}