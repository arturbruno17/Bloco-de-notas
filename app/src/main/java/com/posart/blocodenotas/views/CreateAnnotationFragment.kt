package com.posart.blocodenotas.views

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.posart.blocodenotas.R
import com.posart.blocodenotas.database.entities.Annotation
import com.posart.blocodenotas.databinding.ActivityMainBinding
import com.posart.blocodenotas.databinding.FragmentCreateAnnotationBinding
import com.posart.blocodenotas.viewmodels.CreateAnnotationViewModel

class CreateAnnotationFragment : Fragment() {

    private lateinit var viewModel: CreateAnnotationViewModel
    private lateinit var binding: FragmentCreateAnnotationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateAnnotationBinding.inflate(layoutInflater)

        setHasOptionsMenu(true)

        val activityBinding =
            DataBindingUtil.bind<ActivityMainBinding>(requireActivity().findViewById(R.id.root_activity_main))
        activityBinding?.toolbar?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)

        viewModel = ViewModelProvider(this).get(CreateAnnotationViewModel::class.java)

        return binding.root
    }

    private fun insertDataToDatabase() {
        val title = binding.editTextTitle.text.toString()
        val content = binding.editTextMessage.text.toString()
        if (inputCheck(title, content)) {
            val annotation = Annotation(0, title, content)
            viewModel.insertAnnotation(annotation)
            Snackbar.make(
                binding.root,
                getString(R.string.message_annotation_success),
                Snackbar.LENGTH_SHORT
            ).show()
        } else {
            Snackbar.make(
                binding.root,
                getString(R.string.message_annotation_failed),
                Snackbar.LENGTH_SHORT
            ).show()
        }

    }

    private fun inputCheck(title: String, content: String): Boolean {
        return !(title.isBlank() && content.isBlank())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_button -> {
                insertDataToDatabase()
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