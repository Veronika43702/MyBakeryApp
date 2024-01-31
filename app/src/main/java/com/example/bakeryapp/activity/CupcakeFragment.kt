package com.example.bakeryapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bakeryapp.R
import com.example.bakeryapp.databinding.FragmentCupcakeBinding
import com.example.bakeryapp.databinding.FragmentMenuBinding

class CupcakeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCupcakeBinding.inflate(layoutInflater, container, false)

        binding.spongeMenu.setOnClickListener{
                if (binding.spongeMenu.isChecked) {
                    binding.spongeIngredientTable.visibility = View.GONE
                } else {
                    binding.spongeIngredientTable.visibility = View.VISIBLE
                }
            }

        binding.fillingMenu.setOnClickListener{
            if (binding.fillingMenu.isChecked) {
                binding.fillingIngredientTable.visibility = View.GONE
            } else {
                binding.fillingIngredientTable.visibility = View.VISIBLE
            }
        }

        binding.creamMenu.setOnClickListener{
            if (binding.creamMenu.isChecked) {
                binding.creamIngredientTable.visibility = View.GONE
            } else {
                binding.creamIngredientTable.visibility = View.VISIBLE
            }
        }

        binding.spongeReceiptMenu.setOnClickListener{
            if (binding.spongeReceiptMenu.isChecked) {
                binding.spongeReceipt.visibility = View.GONE
            } else {
                binding.spongeReceipt.visibility = View.VISIBLE
            }
        }

        binding.fillingReceiptMenu.setOnClickListener{
            if (binding.fillingReceiptMenu.isChecked) {
                binding.fillingReceipt.visibility = View.GONE
            } else {
                binding.fillingReceipt.visibility = View.VISIBLE
            }
        }

        binding.creamReceiptMenu.setOnClickListener{
            if (binding.creamReceiptMenu.isChecked) {
                binding.creamReceipt.visibility = View.GONE
            } else {
                binding.creamReceipt.visibility = View.VISIBLE
            }
        }

        return binding.root
    }
}