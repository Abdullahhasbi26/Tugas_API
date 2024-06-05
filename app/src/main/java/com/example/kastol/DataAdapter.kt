package com.example.kastol

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kastol.databinding.ItemDataBinding

class DataAdapter (val data: List<DataItem>?,private val click:onClickItem) :
        RecyclerView.Adapter<DataAdapter.Myholder>(){
            private  lateinit var binding:ItemDataBinding
            inner class Myholder(binding: ItemDataBinding):
                    RecyclerView.ViewHolder(binding.root) {
                        fun onBind(get: DataItem?) {
                            binding.tvName.text = get?.staffName
                            binding.tvPhone.text= get?.staffHp
                            binding.tvAddress.text= get?.staffAlamat
                        }
                    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):Myholder {
        binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return Myholder(binding)
    }

    override fun getItemCount() = data?.size?:0


    override fun onBindViewHolder(holder: Myholder, position: Int) {
        holder.onBind(data?.get(position))
        binding.tvName.setOnClickListener(){
            click.clicked(data?.get(position))
        }
    }
    interface onClickItem{
        fun clicked (item: DataItem?)
        fun delete(item: DataItem?)
    }

        }
