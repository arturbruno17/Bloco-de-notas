package com.posart.blocodenotas.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.posart.blocodenotas.databinding.FragmentFavoritesAnnotationsBinding
import com.posart.blocodenotas.model.asModel
import com.posart.blocodenotas.viewmodels.FavoritesAnnotationsViewModel
import com.posart.blocodenotas.views.annotations.AnnotationsAdapter
import com.posart.blocodenotas.views.annotations.AnnotationsFragmentDirections

class FavoritesAnnotationsFragment : Fragment() {

    private lateinit var viewModel: FavoritesAnnotationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFavoritesAnnotationsBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(FavoritesAnnotationsViewModel::class.java)

        val adapter = AnnotationsAdapter {
            val action = FavoritesAnnotationsFragmentDirections
                .actionFavoritesFragmentToUpdateAnnotationFragment(it.asModel())
            findNavController().navigate(action)
        }
        val layoutManager = GridLayoutManager(context, 2)
        binding.favoritesList.adapter = adapter
        binding.favoritesList.layoutManager = layoutManager

        viewModel.readAllAnnotationsMarkedAsFavorite.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }
}