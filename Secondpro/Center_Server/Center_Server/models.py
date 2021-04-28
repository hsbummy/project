from django.db import models


# 1-1. 사용자 app의 장바구니 품목 목록
class CartList(models.Model):

    cart_num = models.AutoField(db_column='cart_num', primary_key=True)
    table_id = models.IntegerField(db_column='table_id')
    menu_name = models.CharField(db_column='menu_name', max_length=255)
    menu_eng = models.CharField(db_column='menu_eng', max_length=255)
    price = models.IntegerField(db_column='price')
    cart_count = models.IntegerField(db_column='cart_count')
    temp_option = models.IntegerField(db_column='temp_option')
    size_option = models.IntegerField(db_column='size_option')
    cart_price = models.IntegerField(db_column='cart_price')

    class Meta:
        managed = False
        db_table = 'cartlist'

    def __str__(self):
        return "번호 : " + str(self.cart_num) + "테이블 번호 : " + str(self.table_id) + ", 메뉴명 : " + str(self.menu_name) + ", 메뉴영어명 : " + self.menu_eng + \
               ", 메뉴가격 : " + str(self.price) + ", 수량 : " + str(self.cart_count) + ", 옵션 : " + str(self.temp_option) + \
               ", 사이즈 : " + str(self.size_option) + ", 총 결제금액 : " + str(self.cart_price);


# 1-2. 사용자 app의 구매내역 리스트
class BuyList(models.Model):
    buy_id = models.IntegerField(db_column='buy_id')
    table_id = models.IntegerField(db_column='table_id')
    menu_name = models.CharField(db_column='menu_name', max_length=255)
    menu_eng = models.CharField(db_column='menu_eng', max_length=255)
    price = models.IntegerField(db_column='price')
    cart_count = models.IntegerField(db_column='cart_count')
    temp_option = models.IntegerField(db_column='temp_option')
    size_option = models.IntegerField(db_column='size_option')
    cart_price = models.IntegerField(db_column='cart_price')
    buy_date = models.DateTimeField(db_column='buy_date', max_length=100)

    class Meta:
        managed = False
        db_table = 'buylist'

    def __str__(self):
        return "번호 : " + str(self.buy_id) + "메뉴명 : " + str(self.menu_name) + "메뉴 영어명 : " + str(self.menu_eng) +\
               "메뉴가격 : " + str(self.price) + ", 수량 : " + str(self.cart_count)\
               + ", 옵션 : " + str(self.temp_option) + ", 사이즈 : " + str(self.size_option) +\
               ", 총 결제금액 : " + str(self.cart_price);


# 2-1.관리자 app의 주문접수 리스트
class OrderList(models.Model):
    buy_id = models.IntegerField(db_column='buy_id')
    table_id = models.IntegerField(db_column='table_id')
    menu_name = models.CharField(db_column='menu_name', max_length=255)
    menu_eng = models.CharField(db_column='menu_eng', max_length=255)
    price = models.IntegerField(db_column='price')
    cart_count = models.IntegerField(db_column='cart_count')
    temp_option = models.IntegerField(db_column='temp_option')
    size_option = models.IntegerField(db_column='size_option')
    cart_price = models.IntegerField(db_column='cart_price')
    buy_date = models.DateTimeField(db_column='buy_date', max_length=100)

    class Meta:
        managed = False
        db_table = 'orderlist'

    def __str__(self):
        return "번호 : " + str(self.table_id) + "테이블 번호 : " + str(self.table_id) + ", 메뉴명 : " + str(self.menu_name) + \
               ", 메뉴영어명 : " + str(self.menu_eng) + ", 메뉴가격 : " + str(self.price) + ", 수량 : " + str(self.cart_count) +\
               ", 옵션 : " + str(self.temp_option) + ", 사이즈 : " + str(self.size_option) + ", 총 결제금액 : " + str(self.cart_price);


# 2-1.관리자 app의 재고현황 리스트
class TotalStock(models.Model):
    storage_id = models.IntegerField(db_column='storage_id')
    storage_name = models.CharField(db_column='storage_name', max_length=255)
    name = models.CharField(db_column='name', max_length=255)
    s_count = models.IntegerField(db_column='s_count')
    s_date = models.DateTimeField(db_column='s_date', max_length=100)
    shelf = models.DateTimeField(db_column='shelf', max_length=100)
    expire = models.IntegerField(db_column='expire')

    class Meta:
        managed = False
        db_table = 'totalstock'

    def __str__(self):
        return "분류 : " + str(self.storage_name) + "재고 이름 : " + str(self.name) + ", 남은 수량 : " + str(self.s_count) + \
               ", 입고일자 : " + str(self.s_date) + ", 만료일자 : " + str(self.shelf) + ", 남은 일수 : " + str(self.expire)
#######################################################################################################################################
# 관리자 앱 : 1. 커피 재고
class CoffeeBean(models.Model):
    storage_id = models.IntegerField(db_column='storage_id', primary_key=True)
    bean_name = models.CharField(db_column='bean_name', max_length=20)
    bean_count = models.IntegerField(db_column='bean_count',)
    bean_date = models.DateField(db_column='bean_date',)
    bean_shelf = models.DateField(db_column='bean_shelf',)
    bean_expire = models.IntegerField(db_column='bean_expire',)

    class Meta:
        managed = False
        db_table = 'stock_bean'

    def __str__(self):
        return "품목명 : " + self.bean_name + "재고 수량 : " + self.bean_count

# 관리자 앱 : 2. 유제품 재고
class Dairy(models.Model):
    storage_id = models.IntegerField(db_column='storage_id', primary_key=True)
    dairy_name = models.CharField(db_column='dairy_name', max_length=20)
    dairy_count = models.IntegerField(db_column='dairy_count', )
    dairy_date = models.DateField(db_column='dairy_date', )
    dairy_shelf = models.DateField(db_column='dairy_shelf', )
    dairy_expire = models.IntegerField(db_column='dairy_expire', )

    class Meta:
        managed = False
        db_table = 'stock_dairy'

    def __str__(self):
        return "품목명 : " + self.dairy_name + "재고 수량 : " + self.dairy_count

# 관리자 앱 : 3. 디저트 재고
class Dessert(models.Model):
    storage_id = models.IntegerField(db_column='storage_id', primary_key=True)
    dessert_name = models.CharField(db_column='dessert_name', max_length=20)
    dessert_count = models.IntegerField(db_column='dessert_count', )
    dessert_date = models.DateField(db_column='dessert_date', )
    dessert_shelf = models.DateField(db_column='dessert_shelf', )
    dessert_expire = models.IntegerField(db_column='dessert_expire', )
    class Meta:
        managed = False
        db_table = 'stock_dessert'

    def __str__(self):
        return "품목명 : " + self.dessert_name + "재고 수량 : " + self.dessert_count

# 관리자 앱 : 4. 생과일 재고
class Fruit(models.Model):
    storage_id = models.IntegerField(db_column='storage_id', primary_key=True)
    fruit_name = models.CharField(db_column='fruit_name', max_length=20)
    fruit_count = models.IntegerField(db_column='fruit_count', )
    fruit_date = models.DateField(db_column='fruit_date', )
    fruit_shelf = models.DateField(db_column='fruit_shelf', )
    fruit_expire = models.IntegerField(db_column='fruit_expire', )
    class Meta:
        managed = False
        db_table = 'stock_fruit'

    def __str__(self):
        return "품목명 : " + self.fruit_name + "재고 수량 : " + self.fruit_count

# 관리자 앱 : 5. 마카롱 재고
class Macaron(models.Model):
    storage_id = models.IntegerField(db_column='storage_id', primary_key=True)
    mac_name = models.CharField(db_column='mac_name', max_length=20)
    mac_count = models.IntegerField(db_column='mac_count', )
    mac_date = models.DateField(db_column='mac_date', )
    mac_shelf = models.DateField(db_column='mac_shelf', )
    mac_expire = models.IntegerField(db_column='mac_expire', )
    class Meta:
        managed = False
        db_table = 'macaron_frozen'

    def __str__(self):
        return "품목명 : " + self.mac_name + "재고 수량 : " + self.mac_count