package org.nlc.hsackathontracker.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.nlc.hsackathontracker.databinding.ItemHackathonBinding
import org.nlc.hsackathontracker.modal.data.Hackathon
class HackathonAdapter (private val onItemClick: (Hackathon) -> Unit) :
    ListAdapter<Hackathon, HackathonAdapter.ViewHolder>(HackathonDiffCallback()) {

    inner class ViewHolder(private val binding: ItemHackathonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Hackathon) {
            binding.hackathon = item
            binding.executePendingBindings()
            itemView.setOnClickListener { onItemClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHackathonBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}
class HackathonDiffCallback : DiffUtil.ItemCallback<Hackathon>() {
    override fun areItemsTheSame(oldItem: Hackathon, newItem: Hackathon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Hackathon, newItem: Hackathon): Boolean {
        return oldItem == newItem
    }
}

