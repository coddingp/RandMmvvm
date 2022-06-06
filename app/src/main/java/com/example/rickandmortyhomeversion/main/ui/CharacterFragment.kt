package com.example.rickandmortyhomeversion.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.example.rickandmortyhomeversion.common.mvvm.BaseFragment
import com.example.rickandmortyhomeversion.databinding.CharacterBinding
import com.example.rickandmortyhomeversion.main.models.ResultParced

class CharacterFragment(
    @LayoutRes layoutRes: Int
) : BaseFragment(layoutRes) {

    private lateinit var binding: CharacterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data =
            arguments?.getParcelable<ResultParced>("results")
        with(binding) {
            context?.let { Glide.with(it).load(data?.image).into(characterImageView) }
            textViewName.text = buildString { append("Name: ${data?.name}") }
            textViewGender.text = buildString { append("Gender: ${data?.gender}") }
            textViewStatus.text = buildString { append("Status: ${data?.status}") }
            textViewSpecies.text = buildString { append("Species: ${data?.species}") }
            if (data != null) {
                if (data.type != "") {
                    textViewType.text = buildString { append("Type: ${data?.type}") }
                } else textViewType.text = buildString { append("") }
            }
        }
    }
}