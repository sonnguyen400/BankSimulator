<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="customer" scope="request" class="com.sonnguyen.individual.nhs.model.Customer"/>
<jsp:useBean id="membership" scope="request" class="com.sonnguyen.individual.nhs.model.Membership"/>
<div class="row justify-content-center align-items-center gutter-lg-2">
    <div class="col col-sm-12 col-md-6 col-lg-4">
        <div class="row w-100">
            <div class="card w-100">
                <div class="card-body">
                    <div class="d-flex justify-content-center p-3">
                        <div class="w-25">
                            <img class="w-100 h-100 rounded-circle"
                                 src="<c:url  value="/resources/images/avatar/avatar-square1.png"/>">
                        </div>
                    </div>
                    <h4 class="text-center pb-4">${customer.firstname} ${customer.lastname}</h4>
                    <div>
                        <div class="d-flex justify-content-between pb-3">
                            <div class="text-dark">Email</div>
                            <div class="text-secondary">${customer.email}</div>
                        </div>
                        <div class="d-flex justify-content-between pb-3">
                            <div class="text-dark">Phone</div>
                            <div class="text-secondary">${customer.phone}</div>
                        </div>
                        <div class="d-flex justify-content-between pb-3">
                            <div class="text-dark">ID</div>
                            <div class="text-secondary">${customer.social_security_number}</div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="row">
            <button class="btn btn-primary block mr-2">Change email</button>
            <button class="btn btn-primary block">Change password</button>
        </div>
    </div>
</div>
