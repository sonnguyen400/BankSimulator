<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@include file="/taglib/taglib.jsp"%>
<tiles:insertDefinition name="cur.page">
    <tiles:definition name="cur.page" extends="page">
        <tiles:putAttribute name="title" value="HarmonyU"/>
        <tiles:putAttribute name="body">
            <tiles:definition extends="main-wrapper">
                <tiles:putAttribute name="content" >
                    <tiles:definition extends="user.default-layout">
                        <tiles:putAttribute name="content" value="/page/user/AccountCreateNew/ChooseCoopCustomer/content.jsp"/>
                    </tiles:definition>
                </tiles:putAttribute>
            </tiles:definition>
        </tiles:putAttribute>
        <tiles:putAttribute name="inline-script" value="/page/user/AccountCreateNew/ChooseCoopCustomer/script.jsp"/>
    </tiles:definition>
</tiles:insertDefinition>