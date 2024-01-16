package org.techtown.uns_recyclerview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.uns_recyclerview.databinding.TestItemBinding


class TestAdapter : RecyclerView.Adapter<TestAdapter.ViewHolder>() {
    var items = ArrayList<TestData>()

    lateinit var listener: OnTestItemClickListener

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    inner class ViewHolder(val binding: TestItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                listener.onItemClick(this, binding.root, adapterPosition)
            }
        }

        fun setItem(item: TestData) {
            binding.timeText.text = item.time
            binding.idText.text = item.id
            binding.titleText.text = item.title
            binding.contentsText.text = item.contents
        }

    }

}