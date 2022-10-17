package com.kofu.brighton.cryptomint.ui.dashboard

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.kofu.brighton.cryptomint.R
import com.kofu.brighton.cryptomint.data.Repository
import com.kofu.brighton.cryptomint.databinding.FragmentDashboardBinding
import com.kofu.brighton.cryptomint.utils.CurrencyAnalysis
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val viewModel: DashboardViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val args: DashboardFragmentArgs by navArgs()
//        viewModel.fetchCurrency(args.symbol)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.currency.observe(viewLifecycleOwner) {
//            CurrencyAnalysis.calculate(it)
//            binding.totalWalletValueTextview.text = CurrencyAnalysis.totalValue.toString()
//            binding.currencyChangePercentageTextView.text =
//                CurrencyAnalysis.winLossPercentage.toString()
//
//            if (CurrencyAnalysis.winLossPercentage < 0)
//                binding.currencyChangePercentageTextView.setTextColor(binding.root.resources.getColor(
//                    R.color.loss_red))
//
//            if (CurrencyAnalysis.winLossPercentage > 0) {
//                binding.currencyChangePercentageTextView.setTextColor(
//                    binding.root.resources.getColor(
//                        R.color.gain_green
//                    )
//                )
//                binding.currencyChangePercentageTextView.text =
//                    "+ ${binding.currencyChangePercentageTextView.text}"
//            }
//
//            if (CurrencyAnalysis.winLossPercentage == 0.0)
//                binding.currencyChangePercentageTextView.setTextColor(binding.root.resources.getColor(
//                    R.color.black))
//
//
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}