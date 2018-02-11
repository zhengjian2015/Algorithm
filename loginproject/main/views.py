# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render
import json
from users.models import User

# Create your views here.
def index(requset):
    return render(requset,"basemain.html")

def accounts_profile(requset):
    if requset.method == 'POST':
        a = json.loads(requset.body)
        b = User.objects.get(email=requset.user.email) 
        print type(b)   
        b.name = a['name']
        b.sex = a['sex']
        b.birthday = a['birthday']
        b.job_number = a['job_number']
        b.zhengzhi_mianmao = a['zhengzhi_mianmao']
        b.zhengzhi_time = a['zhengzhi_time']
        b.job = a['job']
        b.job_time = a['job_time']
        b.job_2 = a['job_2']
        b.id_number = a['id_number']
        b.xue_li = a['xue_li']
        b.school = a['school']
        b.graduate_time = a['graduate_time']
        b.id_number = a['id_number']
        b.job_join_time = a['job_join_time']
        b.team_belong = a['team_belong']
        b.phone = a['phone']
        b.save()
    return render(requset,"accounts_profile.html")

def modelone(requset):
    return render(requset,"modelone.html")
