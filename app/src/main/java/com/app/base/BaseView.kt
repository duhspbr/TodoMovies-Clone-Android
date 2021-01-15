package com.app.base

interface BaseView<T> {
    var presenter : T
    fun bindViews()
}