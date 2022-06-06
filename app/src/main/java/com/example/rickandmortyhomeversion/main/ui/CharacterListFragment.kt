package com.example.rickandmortyhomeversion.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyhomeversion.R
import com.example.rickandmortyhomeversion.common.mvvm.BaseFragment
import com.example.rickandmortyhomeversion.databinding.CharactersListBinding
import com.example.rickandmortyhomeversion.main.models.ResultParced
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment :
    BaseFragment(R.layout.characters_list) {

    private val adapter: MainAdapter by lazy {
        MainAdapter(onClick = { showDetailsItem(it) })
    }

    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var binding: CharactersListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = CharactersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createRecyclerList()
        mainViewModel.listLiveData.observe(viewLifecycleOwner) { data ->
            adapter.setData(data)
        }
        mainViewModel.loadRickMorty()
    }

    private fun showDetailsItem(resultParced: ResultParced) {
        val fragment = CharacterFragment(R.layout.character)
        val bundle = Bundle()
        bundle.putParcelable("results", resultParced)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.fragmentContainer)
    }

    private fun createRecyclerList() {
        with(binding) {
            charactersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            charactersRecyclerView.adapter = adapter
        }
    }
}