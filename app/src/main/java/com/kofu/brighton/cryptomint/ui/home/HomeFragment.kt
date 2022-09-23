package com.kofu.brighton.cryptomint.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kofu.brighton.cryptomint.databinding.FragmentHomeBinding
import com.kofu.brighton.cryptomint.ui.adapters.CurrencyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: HomeViewModel by activityViewModels()


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val cAdapter = CurrencyAdapter()
        binding.currenciesRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cAdapter
        }
        viewModel.currencies.observe(viewLifecycleOwner) {
            cAdapter.submitList(it)
            viewModel.reconcileRates()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}