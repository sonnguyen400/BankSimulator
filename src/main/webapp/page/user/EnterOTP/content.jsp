<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="static com.sonnguyen.individual.nhs.utils.Constants.OTP" %>
<fmt:setLocale value="${sessionScope.lang}"  />
<fmt:setBundle basename="lang"/>

<div class="row  justify-content-center">
    <div class="col-lg-3 mx-auto" >
        <div class="card">
            <div class="card-body">
                <form method="post" class="" action="<%=request.getContextPath()%>/app/otp">
                    <div class="form-group">
                        <label for="OTP">Enter OTP</label>
                        <input type="password" id="OTP" name="<%=OTP%>" class="form-control">
                        <div class="d-flex justify-content-end mt-3"><button type="submit" class=" btn btn-primary">Continue</button></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>