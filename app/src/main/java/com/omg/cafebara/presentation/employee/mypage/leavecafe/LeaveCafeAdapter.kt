package com.omg.cafebara.presentation.employee.mypage.leavecafe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omg.cafebara.databinding.ItemLeaveCafeListBinding
import com.omg.cafebara.domain.model.CafeList
import com.omg.cafebara.util.view.ItemDiffCallback

class LeaveCafeAdapter: ListAdapter<CafeList, LeaveCafeAdapter.LeaveCafeViewHolder>(
    ItemDiffCallback(
        onContentsTheSame = {old, new -> old == new},
        onItemsTheSame = {old, new -> old.cafeId == new.cafeId}
    )
) {

    inner class LeaveCafeViewHolder(private val binding: ItemLeaveCafeListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CafeList) {
            binding.item = data
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