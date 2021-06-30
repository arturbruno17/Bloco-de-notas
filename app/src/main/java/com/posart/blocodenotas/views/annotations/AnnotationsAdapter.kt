package com.posart.blocodenotas.views.annotations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.posart.blocodenotas.database.entities.Annotation
import com.posart.blocodenotas.databinding.AnnotationBinding

class AnnotationsAdapter(
    private val data: List<Annotation>
) : RecyclerView.Adapter<AnnotationsAdapter.ViewHolder>() {

    class ViewHolder private constructor(
        private val binding: AnnotationBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Annotation) {
            binding.titleCard.text = item.title
            binding.contentCard.text = item.content
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

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

}