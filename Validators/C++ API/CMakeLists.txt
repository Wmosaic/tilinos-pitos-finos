cmake_minimum_required(VERSION 3.26)
project(C__Validators_CLion)

set(CMAKE_CXX_STANDARD 23)

add_executable(C__Validators_CLion main.cpp
        C++Cap.cpp
        C++Val.cpp
        CCap.h
        CVal.h)
