package com.posart.blocodenotas.views

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.posart.blocodenotas.R
import com.posart.blocodenotas.databinding.ActivityMainBinding
import com.posart.blocodenotas.databinding.FragmentCreateAnnotationBinding

class CreateAnnotationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCreateAnnotationBinding.inflate(layoutInflater)

        setHasOptionsMenu(true)

        val activityBinding =
            DataBindingUtil.bind<ActivityMainBinding>(requireActivity().findViewById(R.id.root_activity_main))
        activityBinding?.toolbar?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)



        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_button -> {
                findNavController().navigateUp()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_create_annotation, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}