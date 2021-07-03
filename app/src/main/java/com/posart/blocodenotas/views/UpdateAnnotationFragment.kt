package com.posart.blocodenotas.views

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.posart.blocodenotas.R
import com.posart.blocodenotas.database.entities.Annotation
import com.posart.blocodenotas.databinding.ActivityMainBinding
import com.posart.blocodenotas.databinding.FragmentUpdateAnnotationBinding
import com.posart.blocodenotas.viewmodels.UpdateAnnotationViewModel

class UpdateAnnotationFragment : Fragment() {

    private lateinit var binding: FragmentUpdateAnnotationBinding
    private lateinit var viewModel: UpdateAnnotationViewModel
    private val args by navArgs<UpdateAnnotationFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentUpdateAnnotationBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(UpdateAnnotationViewModel::class.java)

        setHasOptionsMenu(true)

        val activityBinding =
            DataBindingUtil.bind<ActivityMainBinding>(requireActivity().findViewById(R.id.root_activity_main))
        activityBinding?.toolbar?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)

        binding.editUpdateTextTitle.setText(args.annotation.title)
        binding.editUpdateTextMessage.setText(args.annotation.content)

        return binding.root
    }

    private fun updateDataToDatabase() {
        val title = binding.editUpdateTextTitle.text.toString()
        val content = binding.editUpdateTextMessage.text.toString()
        if (inputCheck(title, content)) {
            val annotation = Annotation(args.annotation.id, title, content)
            viewModel.updateAnnotation(annotation)
            Snackbar.make(
                binding.root,
                getString(R.string.message_updated_annotation_success),
                Snackbar.LENGTH_SHORT
            ).show()
        } else {
            Snackbar.make(
                binding.root,
                getString(R.string.message_updated_annotation_failed),
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
                updateDataToDatabase()
                findNavController().navigateUp()
            }
            R.id.delete_button -> {
                viewModel.deleteAnnotation(Annotation(args.annotation.id, "", ""))
                findNavController().navigateUp()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_update_annotation, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}