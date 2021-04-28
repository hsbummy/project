package com.example.cafe_user.ui.order

class OrderMenu {
    var MenuImg:Int = 0
    var MenuName:String = ""
    var MenuDetail:String = ""

    constructor(MenuImg: Int, MenuName: String, MenuDetail: String) {
        this.MenuImg = MenuImg
        this.MenuName = MenuName
        this.MenuDetail = MenuDetail
    }
}