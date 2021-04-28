package com.example.cafe_user.ui.cart

class CartItems {
    var cart_img : Int ?= 0
    var kor_title : String ?= null
    var eng_title : String ?= null
    var cart_item_size : String ?= null
    var cart_item_count : Int ?= 0
    var cart_item_price : Int ?= 0



    constructor(
            cart_img: Int?,
            kor_title: String?,
            eng_title: String?,
            cart_item_size: String?,
            cart_item_count: Int?,
            cart_item_price: Int?
    ) {
        this.cart_img = cart_img
        this.kor_title = kor_title
        this.eng_title = eng_title
        this.cart_item_size = cart_item_size
        this.cart_item_count = cart_item_count
        this.cart_item_price = cart_item_price
    }
}