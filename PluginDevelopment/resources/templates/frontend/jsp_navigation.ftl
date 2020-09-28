<#import "commons/utils.ftl" as u>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link type="text/css" rel="stylesheet" href="${bootstrap_css}">
        <script type="text/javascript" src="${bootstrap_js}"></script>
        <script src="${jquery}"></script>       
        <link rel="stylesheet" type="text/css" href="${datatables_css}">
        <script type="text/javascript" charset="utf8" src="${datatables_js}"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
           <a class="navbar-brand font-weight-bold" href="/">${app_name}</a>
           <div class="collapse navbar-collapse" id="navbarNav">
               <ul class="nav navbar-nav">
               <#list entities as entity>
                  <li class="nav-item">
                  	 <#assign entity_var = "${" + entity.name?uncap_first + "_all}">
                  	 <c:url var="${entity.name?uncap_first + "_all"}" value="/all${entity.name?cap_first}s" />
                     <a class="nav-link" href="${entity_var}">${entity.name?cap_first}</a>
                  </li>
	           </#list>
               </ul>

           </div>
        </nav>
    </body>
</html>