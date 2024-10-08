<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="static com.sonnguyen.individual.nhs.utils.Constants.PIN" %>
<fmt:setLocale value="${sessionScope.lang}"  />
<fmt:setBundle basename="lang"/>

<div class="row  justify-content-center">
    <div class="col-lg-3 mx-auto" >
        <div class="card">
            <div class="card-body">
                <form method="post" class="" action="<%=request.getContextPath()%>/app/pin">
                    <div class="form-group">
                        <label>Enter your PIN</label>
                        <input type="password" id="PIN" name="<%=PIN%>" class="form-control">
                        <div class="d-flex justify-content-end mt-3"><button type="submit" class=" btn btn-primary">Continue</button></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>