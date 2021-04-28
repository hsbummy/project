from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from rest_framework.parsers import JSONParser

from Center_Server.models \
    import CartList, BuyList, TotalStock, OrderList, \
            CoffeeBean, Dairy, Dessert, Fruit, Macaron
from Center_Server.serializer \
    import CartListSerializer, TotalSerializer, BuyListSerializer, OrderListSerializer, \
            CoffeeSerializer, DairySerializer, DessertSerializer, FruitSerializer, MacaronSerializer


## tips
## www.django-rest-framework.org/tutorial/quickstart/


def index(request):
    return render(request, "index.html")


def get_CartInfo(request):
    datalist = CartList.objects.all()
    print(datalist)
    if request.method == 'GET':
        print("test=====")
        serializer = CartListSerializer(datalist, many=True)
        print(serializer)
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii': False})

    # 클라이언트에서 넘어오는 데이터를 가지고 작업 - 데이터가 JSON형식으로 전달


def post_CartInfo(request):
    if request.method == 'POST':
        print("request_ok")
        data = JSONParser().parse(request)
        print(data)
        cart_num = data['cart_num']
        print(cart_num)
        obj = CartList.objects.get(cart_num=int(cart_num))
        print(obj)
        if data['menu_name'] == obj.writer:
            return JsonResponse("ok", safe=False, json_dumps_params={'ensure_ascii': False})
        else:
            return JsonResponse("fail", safe=False, json_dumps_params={'ensure_ascii': False})


def get_BuyInfo(request):
    datalist = BuyList.objects.all()
    print(datalist)
    if request.method == 'GET':
        print("test=====")
        serializer = BuyListSerializer(datalist, many=True)
        print(serializer)
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii': False})


def get_stock(request):
    datalist = TotalStock.objects.all()
    print(datalist)
    if request.method == 'GET':
        print("test=====")
        serializer = TotalSerializer(datalist, many=True)
        print(serializer)
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii': False})


def get_order(request):
    datalist = OrderList.objects.all()
    print(datalist)
    if request.method == 'GET':
        print("test=====")
        serializer = OrderListSerializer(datalist, many=True)
        print(serializer)
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii': False})

############################################################################################################

def CoffeeStock(request):
    datalist = CoffeeBean.objects.all()
    if request.method == 'GET':
        serializer = CoffeeSerializer(datalist, many=True)
        return JsonResponse(serializer.data, safe=False,
                            json_dumps_params={'ensure_ascii': False})

def DairyStock(request):
    datalist = Dairy.objects.all()
    if request.method == 'GET':
        serializer = DairySerializer(datalist, many=True)
        return JsonResponse(serializer.data, safe=False,
                            json_dumps_params={'ensure_ascii': False})

def DessertStock(request):
    datalist = Dessert.objects.all()
    if request.method == 'GET':
        serializer = DessertSerializer(datalist, many=True)
        return JsonResponse(serializer.data, safe=False,
                            json_dumps_params={'ensure_ascii': False})

def FruitStock(request):
    datalist = Fruit.objects.all()
    if request.method == 'GET':
        serializer = FruitSerializer(datalist, many=True)
        return JsonResponse(serializer.data, safe=False,
                            json_dumps_params={'ensure_ascii': False})

def MacaronStock(request):
    datalist = Macaron.objects.all()
    if request.method == 'GET':
        serializer = MacaronSerializer(datalist, many=True)
        return JsonResponse(serializer.data, safe=False,
                            json_dumps_params={'ensure_ascii': False})