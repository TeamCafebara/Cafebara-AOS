package com.omg.cafebara.presentation.employee.mypage.leavecafe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omg.cafebara.R
import com.omg.cafebara.databinding.ItemLeaveCafeListBinding
import com.omg.cafebara.domain.model.CafeList
import com.omg.cafebara.util.view.ItemDiffCallback

class LeaveCafeAdapter : ListAdapter<CafeList, LeaveCafeAdapter.LeaveCafeViewHolder>(
    ItemDiffCallback(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.cafeId == new.cafeId }
    )
) {

    private var onItemClickListener: OnItemClickListener? = null
    private var selectedPosition: Int? = null
    var clickedCafeId: Int = 1

    interface OnItemClickListener {
        fun onItemClick(item: CafeList, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    inner class LeaveCafeViewHolder(private val binding: ItemLeaveCafeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CafeList) {
            binding.item = data

            if (selectedPosition == adapterPosition) {
                changeItemColor(binding, true)
            } else {
                changeItemColor(binding, false)
            }

            if (onItemClickListener != null) {
                binding.root.setOnClickListener {
                    onItemClickListener?.onItemClick(data, adapterPosition)
                    if (selectedPosition != adapterPosition) {
                        changeItemColor(binding, true)
                        selectedPosition?.let { it1 -> notifyItemChanged(it1) }
                        selectedPosition = adapterPosition
                    }
                    clickedCafeId = data.cafeId
                }
            }
        }
    }

    private fun changeItemColor(
        binding: ItemLeaveCafeListBinding,
        selected: Boolean,
    ) {
        when (selected) {
            true -> {
                binding.root.setBackgroundResource(R.drawable.shape_blue10_fill_blue_line_8_rect)
                binding.tvLeaveCafeName.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.blue100
                    )
                )
            }

            false -> {
                binding.root.setBackgroundResource(R.drawable.shape_gray1_line_8_rect)
                binding.tvLeaveCafeName.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.gray7
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveCafeViewHolder {
        val binding = ItemLeaveCafeListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LeaveCafeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LeaveCafeViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}
