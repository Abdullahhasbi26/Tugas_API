package com.example.kastol

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kastol.databinding.ActivityUpdateAddBinding
import kotlin.math.log

@Suppress("SENSELESS_COMPARISON")
class UpdateAddActivity : AppCompatActivity(),CrudView {
    private lateinit var presenter: Presenter2
    private lateinit var binding: ActivityUpdateAddBinding

    @SuppressLint("SeTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem == null) {
            binding.btnAction.text = "Tambah"
            binding.btnAction.setOnClickListener() {
                Log.d("UpdateAddActivity", "Tambah button clicked")
                presenter.adddata(
                    binding.etName.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAddress.text.toString()
                )
            }
        } else if (itemDataItem != null) {
            binding.btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            binding.etName.setText(item?.staffName.toString())
            binding.etPhone.setText(item?.staffHp.toString())
            binding.etAddress.setText(item?.staffAlamat.toString())
            binding.btnAction.setOnClickListener() {
                presenter.updateData(
                    item?.staffId ?: "",
                    binding.etName.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAddress.text.toString()
                )
                finish()
            }
        }
    }

    override fun successAdd(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onErrorAdd(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGet(data: List<DataItem>) {
        TODO("Not yet implemented")
    }

    override fun onFailedGet(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessUpdate(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onErrorUpdate(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessDelete(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onErrorDelete(msg: String) {
        TODO("Not yet implemented")
    }
}