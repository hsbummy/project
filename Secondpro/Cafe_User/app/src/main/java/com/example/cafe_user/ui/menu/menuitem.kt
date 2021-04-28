package com.example.cafe_user.ui.menu

class menuitem {
    var menuimg : Int ?= 0
    var kor_title : String ?= null
    var eng_title : String ?= null
    var menu_detail : String ?= null
    var price : Int ?= 0

    constructor(
            menuimg: Int?,
            kor_title: String?,
            eng_title: String?,
            menu_detail: String?,
            price: Int?
    ) {
        this.menuimg = menuimg
        this.kor_title = kor_title
        this.eng_title = eng_title
        this.menu_detail = menu_detail
        this.price = price
    }
}