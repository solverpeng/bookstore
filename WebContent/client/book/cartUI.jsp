<%--
  Created by IntelliJ IDEA.
  User: xzsw
  Date: 2016/6/14
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="/common.jsp"%>
    <title>Title</title>
    <script type="text/javascript">
        $(function() {
            $("#clearCart").click(function () {
                var flag = confirm("真的要清空购物车?");
                if(!flag) {
                    return false;
                }
            });
        });

    </script>
</head>
<body>
    <table class="styleTable">
        <tr>
            <td class="centerTd" colspan="5">购物车信息</td>
        </tr>

        <c:if test="${empty cart || cart.cartEmpty }">

            <tr>
                <td class="centerTd" colspan="5">购物车中还没有商品</td>
            </tr>

        </c:if>
        <c:if test="${!empty cart && !cart.cartEmpty }">

            <tr>
                <td class="centerTd" colspan="5">您的购物车中有${cart.totalCount }件商品</td>
            </tr>
            <tr>
                <td>名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${cart.itemMap }" var="entry">
                <!-- entry的key:bookId -->
                <!-- entry的value:CartItem对象 -->
                <tr>
                    <td>${entry.value.book.bookName }</td>
                    <td>
                        <!-- 在文本框中显示图书数量 -->
                        <!-- value属性值：图书数量 -->
                        <!-- 使用表单隐藏域保存bookId -->
                        <button class="derecease">-</button>
                        <input type="hidden" name="bookId" value="${entry.key }" />
                        <input class="shortInp" type="text" value="${entry.value.count }" />
                        <button class="increase">+</button>
                    </td>
                    <td>${entry.value.book.price }</td>
                    <td>${entry.value.amount }</td>
                    <td><a class="removeCartItem" href="client/CartServlet?method=removeCartItem&bookId=${entry.key }">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td>总金额：${cart.totalAmount }</td>
                <td class="centerTd" colspan="3"><a id="clearCart" href="client/CartServlet?method=clearCart">清空购物车</a></td>
                <td>结账</td>
            </tr>
        </c:if>

        <tr>
            <td class="centerTd" colspan="5"><a href="client/BookClientServlet?method=getPage">继续购物</a></td>
        </tr>
    </table>
</body>
</html>
