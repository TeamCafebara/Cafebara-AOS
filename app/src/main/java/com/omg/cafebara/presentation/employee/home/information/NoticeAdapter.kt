package com.omg.cafebara.presentation.employee.home.information

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omg.cafebara.databinding.ItemHomeInformationBinding
import com.omg.cafebara.domain.model.NoticeData
import com.omg.cafebara.util.view.ItemDiffCallback

class NoticeAdapter :
    ListAdapter<NoticeData, NoticeAdapter.NoticeViewHolder>(
        ItemDiffCallback<NoticeData>(
            onItemsTheSame = { old, new -> old.noticeId == new.noticeId },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {

    class NoticeViewHolder(private val binding: ItemHomeInformationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: NoticeData) {
            with(binding) {
                tvHomeInformationNoticeType.text = data.noticeType
                tvHomeInformationListTitle.text = data.noticeTitle
                tvHomeInformationListDate.text = data.noticeModifiedAt
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val binding = ItemHomeInformationBinding.inflate(
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