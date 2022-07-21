package br.com.zup.fcm.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.fcm.databinding.FragmentMainBinding
import br.com.zup.fcm.domain.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }
    private fun initObserver(){
        viewModel.currentToken.observe(viewLifecycleOwner){
            binding.token.text = it
        }
        viewModel.lastNotification.observe(viewLifecycleOwner){
            binding.notificationTitle.text = it.title
            binding.notificationTitle.text = it.body
        }
    }
}