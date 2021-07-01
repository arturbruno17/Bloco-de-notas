package com.posart.blocodenotas.views.annotations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.posart.blocodenotas.database.entities.Annotation
import com.posart.blocodenotas.databinding.AnnotationBinding
import com.posart.blocodenotas.model.asModel

class AnnotationsAdapter : ListAdapter<Annotation, AnnotationsAdapter.ViewHolder>(AnnotationItemCallBack()) {

    class ViewHolder private constructor(
        private val binding: AnnotationBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Annotation) {
            binding.titleCard.text = item.title
            binding.contentCard.text = item.content
            binding.card.setOnClickListener {
                val action = AnnotationsFragmentDirections.actionAnnotationFragmentToUpdateAnnotationFragment(
                    item.asModel()
                )
                it.findNavController().navigate(action)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = AnnotationBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class AnnotationItemCallBack : DiffUtil.ItemCallback<Annotation>() {
    override fun areItemsTheSame(oldItem: Annotation, newItem: Annotation): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Annotation, newItem: Annotation): Boolean {
        return oldItem == newItem
    }

}