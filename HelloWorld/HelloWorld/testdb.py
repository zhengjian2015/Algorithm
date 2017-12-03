#coding:utf-8
from django.http import HttpResponse

from TestModel.models import Test

#数据库操作
def testdb(request):
	'''
	#添加数据
	test1 = Test(name='runnbo')
	test1.save() # save 函数，相当于SQL中的INSERT：
	return HttpResponse("<p>数据添加成功！</p>")
	'''
	#初始化
	response = ''
	response1 = ''

	# 通过objects这个模型管理器的all()获得所有数据行，相当于SQL中的SELECT * FROM
	list = Test.objects.filter(id=1)
	print type(list)
	#获取单个对象
	response3 = Test.objects.get(id=1)

	#数据排序
	Test.objects.order_by('name')[0:2]
	#上面的方法可以连锁使用
	Test.objects.filter(name='runoob').order_by("id")
	#输出所有数据
	for var in list:
		print type(var)
		response1 += var.name+" "
	response = response1
	return HttpResponse("<p>"+ response +"</p>")
