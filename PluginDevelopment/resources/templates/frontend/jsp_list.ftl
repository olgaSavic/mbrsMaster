<#import "commons/utils.ftl" as u>
<#assign class_name_cap = class.name?cap_first>
<#assign class_name = class.name?uncap_first>
<#assign class_name_id = "${" + class_name + ".id" + "}">
<#assign class_name_plural = class_name + "s">
<#assign empty_word = "empty ">
<#macro print_complex_property prop>
	<#local property_name_url = prop.type?uncap_first />
	<#local property_name = prop.name />
	<#local property_name_cap = property_name?cap_first />
	<#local property_id = "${" + class_name + "." + property_name  + "}" />
                            <td> ${property_id}</td>
</#macro>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of ${class_name_plural}</title>
    </head>
    <body>
        <%@ include file="navigation.jsp"%>
        <div class="container">
            <br/>
            <h3 class="text-center">List of ${class_name_plural}</h3>
            <div>
                 <a class="btn btn-outline-primary btn-sm float-right mb-3" href="<c:url value="/${class_name}/new"/>">Add new ${class_name}</a>
            </div>
            <div>
                 <table id="table_id" class="table table-sm table-hover table-bordered text-center mt-3">
                    <thead>
                    	<tr>
                        	<#list properties as property>
                        	<th>${property.name?cap_first}</th>
                        	</#list>
                        	<th>Action</th>
                    	</tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${ "${" + class_name_plural + "}" }" var="${class_name}">
                    	<tr>
                    		<#list properties as property>
                        	<#if entity_properties[property.type]??>
                        	<#if property.upper == -1>
                        	<td>

                        	<c:forEach items="${ "${" + class_name + "." + property.name + "}" }">

                        	</c:forEach>
                        	</td>
                        	<#else>
                        	<@print_complex_property prop = property />
                        	</#if>
                        	<#else>
                        	<td>${ "${" + class_name + "." + property.name +  "}" }</td>
			            	</#if>
                    		</#list>
                        	<td>
                                <a class="btn btn-sm btn-success" href="<c:url value="/${class_name}/${class_name_id}"/>">Detail</a>
                                <a class="btn btn-sm btn-warning" href="<c:url value="/${class_name}/edit?id=${class_name_id}"/>">Edit</a>
                                <a class="btn btn-sm btn-danger" href="<c:url value="/${class_name}/delete?id=${class_name_id}"/>">Delete</a>
                        	</td>
                    	</tr>
                    	</c:forEach>
                    </tbody>
                 </table>
            </div>
         </div>
   </body>
</html>