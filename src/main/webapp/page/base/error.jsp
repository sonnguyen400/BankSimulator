<%@ page import="static com.sonnguyen.individual.nhs.utils.RequestUtils.ERROR_MESSAGE" %>
<%@include file="/taglib/taglib.jsp"%>
<%!int status;String error;%>
<%
    status=response.getStatus();
    error=(String) request.getAttribute(ERROR_MESSAGE);
    if(error==null) error="Unknown error";
%>
<% final String errorMessage = (String)request.getAttribute("ErrorMessage"); %>
<!DOCTYPE html>
<html class="h-100" lang="en">

<head>
    <%@include file="/taglib/header.jsp"%>
    <%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isErrorPage="true"%>
    <title><%out.print(status);%></title>

</head>

<body class="h-100">
<!--*******************
    Preloader start
********************-->
<div id="preloader">
    <div class="loader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
        </svg>
    </div>
</div>
<!--*******************
    Preloader end
********************-->
<div class="login-form-bg h-100">
    <div class="container h-100">
        <div class="row justify-content-center h-100">
            <div class="col-xl-6">
                <div class="error-content">
                    <div class="card mb-0">
                        <div class="card-body text-center">
                            <h1 class="error-text text-primary">
                                <%=status%>
                            </h1>
                            <h4 class="mt-4"><i class="fa fa-thumbs-down text-danger"></i> Bad Request</h4>
                            <p><%=error%></p>
                            <small>
                                <%
                                    if(exception!=null){
                                        out.println(exception.getLocalizedMessage());
                                        out.println(exception.getMessage());
                                        out.println(exception.toString());
                                        exception.printStackTrace();
                                    }
                                %>

                                <%= errorMessage %><br><br>
                            </small>
                            <form class="mt-5 mb-5">
                                <div class="text-center mb-4 mt-4"><a href="${pageContext.request.contextPath}/" class="btn btn-primary">Go to Homepage</a>
                                </div>
                            </form>
                            <div class="text-center">
                                <p>Copyright � Designed by <a href="https://themeforest.net/user/digitalheaps">Digitalheaps</a>, Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018</p>
                                <ul class="list-inline">
                                    <li class="list-inline-item"><a href="javascript:void()" class="btn btn-facebook"><i class="fa fa-facebook"></i></a>
                                    </li>
                                    <li class="list-inline-item"><a href="javascript:void()" class="btn btn-twitter"><i class="fa fa-twitter"></i></a>
                                    </li>
                                    <li class="list-inline-item"><a href="javascript:void()" class="btn btn-linkedin"><i class="fa fa-linkedin"></i></a>
                                    </li>
                                    <li class="list-inline-item"><a href="javascript:void()" class="btn btn-google-plus"><i class="fa fa-google-plus"></i></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/taglib/basescript.jsp"%>
</body>
</html>
