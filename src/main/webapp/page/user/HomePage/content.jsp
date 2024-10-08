
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" %>
<%--<fmt:setLocale value="lang" scope="session"/>--%>
<jsp:useBean id="account"  scope="request" class="com.sonnguyen.individual.nhs.model.Account"/>
<fmt:setLocale value="${sessionScope.lang}"  />
<fmt:setBundle basename="lang"/>
<div class="row">
    <div class="col-lg-4 col-xl-3">
        <a href="<%=request.getContextPath()%>/app/account/manage">
            <div class="card gradient-1">
                <div class="card-body">
                    <div class="text-center">
                        <span class="text-md-11 opacity-5 text-white"><i class="fi fi-sr-sack-dollar"></i></span>
                        <h6 class="mt-2 mb-2 text-white-50 text-white"><fmt:message key="balance"/></h6>
                        <h3 class="text-white">
                            <fmt:formatNumber  value="${account.balance}"  currencyCode=","/>
                        </h3>
                        <button class="btn gradient-3 btn-lg border-0 btn-rounded px-5">
                            <i class="fi fi-sr-eye"></i>
                        </button>
                    </div>
                </div>
            </div>
        </a>
    </div>

    <%--    Carousel--%>
    <div class="col-lg-8 col-xl-6">
        <div  id="carouselExampleCaptions" style="height: 100%;max-height: 217px" class="carousel slide card"
             style="overflow: hidden;"
             data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img style="object-fit: contain" src="<c:url value="/resources/images/banner/banner1.jpg"/>" class="d-block w-100" alt="...">

                </div>
                <div class="carousel-item">
                    <img style="object-fit: contain" src="<c:url value="/resources/images/banner/banner2.jpg"/>"  class="d-block w-100" alt="...">

                </div>
            </div>
            <button class="slide-control left" data-target="#carouselExampleCaptions" data-slide="prev">
                <i class="fa-solid fa-angle-left"></i>
                <span class="sr-only">Previous</span>
            </button>
            <button class="slide-control right" data-target="#carouselExampleCaptions" data-slide="next">
                <i class="fa-solid fa-angle-right"></i>
            </button>
        </div>
    </div>
</div>

<%--Toolbar--%>
<div class="row ">
    <a href="${pageContext.request.contextPath}/app/transfer" class="col-md-3 col-sm-6">
        <div class="card react-widget gradient-2">
            <div class="gutter-md-2">
                <div class="col">
                    <h4 class="text-white text-md-8"><fmt:message key="transfer"/></h4>
                    <span class="float-right text-md-11 opacity-5 "><i
                            class="fi fi-sr-money-bill-transfer"></i></span>
                </div>
            </div>
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/app/history" class="col-md-3 col-sm-6">
        <div class="card react-widget gradient-3">
            <div class="gutter-md-2">
                <div class="col">
                    <h4 class="text-white text-md-8"><fmt:message key="history"/></h4>
                    <span class="float-right text-md-11 opacity-5 "><i
                            class="fi fi-sr-clock"></i></span>
                </div>
            </div>
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/app/loan" class="col-md-3 col-sm-6">
        <div class="card react-widget gradient-3">
            <div class="gutter-md-2">
                <div class="col">
                    <h4 class="text-white text-md-8"><fmt:message key="loan.title"/></h4>
                    <span class="float-right text-md-11 opacity-5 ">
                        <i class="fi fi-sr-hand-holding-usd"></i>
                    </span>
                </div>
            </div>
        </div>
    </a>
    <a href="<%=request.getContextPath()%>/app/saving" class="col-md-3 col-sm-6">
        <div class="card react-widget gradient-4">
            <div class="gutter-md-2">
                <div class="col">
                    <h4 class="text-white text-md-8"><fmt:message key="savings.title"/> </h4>
                    <span class="float-right text-md-11 opacity-5 ">
                        <i class="fi fi-sr-piggy-bank"></i>
                    </span>
                </div>
            </div>
        </div>
    </a>

</div>