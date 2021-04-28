from rest_framework import serializers

from Center_Server.models \
    import CartList, BuyList, OrderList, TotalStock, \
            CoffeeBean, Dairy, Dessert, Fruit, Macaron


class CartListSerializer(serializers.ModelSerializer):
    class Meta:
        model = CartList
        fields = ['table_id', 'menu_name', 'cart_count', 'temp_option', 'size_option', 'cart_price']


class BuyListSerializer(serializers.ModelSerializer):
    class Meta:
        model = BuyList
        fields = ['cart_num', 'table_id', 'menu_name', 'cart_count', 'temp_option', 'size_option', 'cart_price']


class OrderListSerializer(serializers.ModelSerializer):
    class Meta:
        model = OrderList
        fields = ['cart_num', 'table_id', 'menu_name', 'cart_count', 'temp_option', 'size_option', 'cart_price']


class TotalSerializer(serializers.ModelSerializer):
    class Meta:
        model = TotalStock
        fields = ['cart_num', 'table_id', 'menu_name', 'cart_count', 'temp_option', 'size_option', 'cart_price']

##########################################################################################################################

class CoffeeSerializer(serializers.ModelSerializer):
    class Meta:
        model = CoffeeBean
        fields = ['storage_id', 'bean_name', 'bean_count', 'bean_date', 'bean_shelf', 'bean_expire']

class DairySerializer(serializers.ModelSerializer):
    class Meta:
        model = Dairy
        fields = ['storage_id', 'dairy_name', 'dairy_count', 'dairy_date', 'dairy_shelf', 'dairy_expire']

class DessertSerializer(serializers.ModelSerializer):
    class Meta:
        model = Dessert
        fields = ['storage_id', 'dessert_name', 'dessert_count', 'dessert_date', 'dessert_shelf', 'dessert_expire']

class FruitSerializer(serializers.ModelSerializer):
    class Meta:
        model = Fruit
        fields = ['storage_id', 'fruit_name', 'fruit_count', 'fruit_date', 'fruit_shelf', 'fruit_expire']

class MacaronSerializer(serializers.ModelSerializer):
    class Meta:
        model = Macaron
        fields = ['storage_id', 'mac_name', 'mac_count', 'mac_date', 'mac_shelf', 'mac_expire']