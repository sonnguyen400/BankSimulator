<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@include file="/taglib/taglib.jsp"%>



<tiles:definition name="cur.page" extends="page">
    <tiles:putAttribute name="title" value="HarmonyU"/>
    <tiles:putAttribute name="body">
        <tiles:definition extends="main-wrapper">
            <tiles:putAttribute name="content">
                <tiles:definition  extends="user.header-layout">
                    <tiles:putAttribute name="content" value="/page/user/EnterPin/content.jsp"/>
                </tiles:definition>
            </tiles:putAttribute>
        </tiles:definition>
    </tiles:putAttribute>
    <tiles:putAttribute name="script"  value="transfer_page_script"/>
    <tiles:putAttribute name="inline-script" value="/page/user/EnterPin/script.jsp"/>
</tiles:definition>


<tiles:insertDefinition name="cur.page"/>