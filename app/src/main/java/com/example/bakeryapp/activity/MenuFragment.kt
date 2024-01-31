package com.example.bakeryapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bakeryapp.R
import com.example.bakeryapp.databinding.FragmentMenuBinding
import com.google.android.material.snackbar.Snackbar

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMenuBinding.inflate(layoutInflater, container, false)

        // переход на фрагмент списка товаров
        binding.goodListButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_menu_to_fragment_goods,
                )
        }

        // переход на фрагмент списка временных товаров
        binding.temporaryListButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_menu_to_fragment_temp_goods,
            )
        }

        // переход на фрагмент списка компонентов
        binding.componentListButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_menu_to_fragment_components,
            )
        }

        // переход на фрагмент списка продуктов
        binding.productListButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_menu_to_fragment_products,
            )
        }

        // переход на фрагмент конструктора капкейков
        binding.cupcakeConstructorButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_menu_to_fragment_cupcake,
            )
        }

        // переход на фрагмент конструктора тортов
        binding.cakeConstructorButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_menu_to_fragment_cake,
            )
        }

        return binding.root
    }
}