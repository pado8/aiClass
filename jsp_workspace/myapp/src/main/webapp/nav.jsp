<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <style>
        nav {
            height: 50px;
            background: gray;
            line-height: 50px;
        }

        nav>a.on {
            background: RGB(4, 170, 109);
            color: #ffffff;
        }

        a {
            text-decoration: none;
            color: #ffffff;
            padding: 14px 16px 15px 16px;
        }

        a:hover {
            background-color: #dddddd;
            color: #000000;
        }
    </style>

    <!-- 네비게이션 ------------------------------------------>
    <nav>
        <!-- 화사 소개 | 회사 연혁 | 과정 소개 -->
        <a class="on" href="#">회사 소개</a><a href="#">회사 연혁</a><a href="#">과정 소개</a>
    </nav>
    <!-- /네비게이션 -->