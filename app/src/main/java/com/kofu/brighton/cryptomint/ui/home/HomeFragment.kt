package com.kofu.brighton.cryptomint.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kofu.brighton.cryptomint.databinding.FragmentHomeBinding
import com.kofu.brighton.cryptomint.ui.adapters.CurrencyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView: TextView = binding.textHome
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val cAdapter = CurrencyAdapter(clickListener = {
            Toast.makeText(context, it.symbol, Toast.LENGTH_LONG).show()
        })

        binding.currenciesRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cAdapter
        }

        viewModel.currencies.observe(viewLifecycleOwner) {
            cAdapter.submitList(it)
            viewModel.reconcileRates()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}