package com.omg.cafebara.presentation.employee.home.notice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omg.cafebara.databinding.ItemHomeNoticeBinding
import com.omg.cafebara.domain.model.NoticeData
import com.omg.cafebara.util.view.ItemDiffCallback

class NoticeAdapter :
    ListAdapter<NoticeData, NoticeAdapter.NoticeViewHolder>(
        ItemDiffCallback(
            onItemsTheSame = { old, new -> old.noticeId == new.noticeId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    private var onItemClickListener: ((NoticeData) -> Unit)? = null

    inner class NoticeViewHolder(private val binding: ItemHomeNoticeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: NoticeData) {
            with(binding) {
                item = data
                root.setOnClickListener {
                    onItemClickListener?.let { it(data) }
                }
            }
        }
    }

    fun setOnNoticeDataClickListener(listener: (NoticeData) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val binding = ItemHomeNoticeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NoticeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}
