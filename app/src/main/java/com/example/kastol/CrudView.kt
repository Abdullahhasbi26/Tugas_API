package com.example.kastol

interface CrudView {
    fun successAdd(msg:String)
    fun onErrorAdd(msg: String)

    //untuk Get data
    fun onSuccessGet (data: List<DataItem>)
    fun onFailedGet (msg: String)

    //untuk update
    fun onSuccessUpdate (msg: String)
    fun onErrorUpdate (msg: String)
    //untuk delete
    fun onSuccessDelete (msg: String)
    fun onErrorDelete (msg: String)
}