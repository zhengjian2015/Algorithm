# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render

# Create your views here.
def index(requset):
    return render(requset,"basemain.html")

def accounts_profile(requset):
    return render(requset,"basemain.html")
