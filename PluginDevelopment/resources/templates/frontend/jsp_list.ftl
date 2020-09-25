<#import "commons/utils.ftl" as u>
<#assign class_name_cap = class.name?cap_first>
<#assign class_name = class.name?uncap_first>
<#assign class_name_id = "${" + class_name + ".id" + "}">
<#assign class_name_plural = u.plural(class_name)>
<#assign empty_word = "empty ">
<#macro print_complex_property prop>
	<#local property_name_url = prop.type?uncap_first />
	<#local property_name = prop.name />
	<#local property_name_cap = property_name?cap_first />
	<#local property_id = "${" + class_name + "." + property_name  + "}" />
                            <td><a href="<c:url value="/${property_name_url}/${property_id}"/>"> ${property_id}</a></td>
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
        <script>
	        $(document).ready( function () {
    	        var table = $('#table_id').DataTable(
    			    {
    		            responsive: true
    		        }
    	        );

	        } );
        </script>
        <div class="container">
            <h5 class="text-center">List of ${class_name_plural}</h5>
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
                        	<#-- Not sure about @ManyToMany -->
                        	<td>

                        	<c:forEach items="${ "${" + class_name + "." + property.name + "}" }">

                        	</c:forEach>
                        	</td>
                        	<#else>
                        	<#-- @ManyToOne or @OneToOne -->
                        	<@print_complex_property prop = property />
                        	</#if>
                        	<#else>
                        	<td>${ "${" + class_name + "." + property.name +  "}" }</td>
			            	</#if>
                    		</#list>
                        	<td>
                            	<a class="btn btn-sm btn-info" href="<c:url value="/${class_name}/${class_name_id}"/>">Detail</a>
                            	<a class="btn btn-sm btn-primary" href="<c:url value="/${class_name}/edit?id=${class_name_id}"/>">Edit</a>
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