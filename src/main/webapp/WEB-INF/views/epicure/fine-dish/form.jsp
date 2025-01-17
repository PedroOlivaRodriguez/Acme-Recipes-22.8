<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

		
		<acme:form readonly="true">
			<acme:input-textbox code="epicure.fine-dish.form.label.status" path="status"/>	
			<acme:input-textbox code="epicure.fine-dish.form.label.code" path="code"/>	
			<acme:input-textbox code="epicure.fine-dish.form.label.request" path="request"/>	
			<acme:input-textbox code="epicure.fine-dish.form.label.budget" path="budget"/>
			<acme:input-textbox code="epicure.fine-dish.form.label.initialDate" path="initialDate"/>
			<acme:input-textbox code="epicure.fine-dish.form.label.finishDate" path="finishDate"/>
			<acme:input-textbox code="epicure.fine-dish.form.label.url" path="url"/>
			<acme:button code="epicure.fine-dish.form.label.chef" action="/any/user-account/show?id=${chefId}"/>
		</acme:form>
		




