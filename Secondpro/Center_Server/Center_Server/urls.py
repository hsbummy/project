from django.urls import path
from Center_Server import views

urlpatterns = [
    path('', views.index, name="index"),
    path('cart', views.get_CartInfo, name="cart"),
    path('buy', views.get_BuyInfo, name="buy"),
    path('stock', views.get_stock, name="stock"),
    path('order', views.get_order, name="order"),
    path('coffee', views.CoffeeStock, name="coffee"),
    path('dairy', views.DairyStock, name="dairy"),
    path('dessert', views.DessertStock, name="dessert"),
    path('fruit', views.FruitStock, name="fruit"),
    path('macaron', views.MacaronStock, name="macaron")
]
