<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
    <%@ include file="navigation.jsp"%>
    <div class="container">
        <div class="text-center mt-2">
            <h5>ReportItem details</h5>
            <div>
                 <div>
                        <div class="m-2">
                            <span>Id: <span class="font-weight-bold">${reportItem.id}</span></span>
                        </div>
                        <hr class="my-2">			            
                        <div class="m-2">
                            <span>Name: <span class="font-weight-bold">${reportItem.name}</span></span>
                        </div>
                        <hr class="my-2">			            
                        <div class="m-2">
                            <span>Description: <span class="font-weight-bold">${reportItem.description}</span></span>
                        </div>
                        <hr class="my-2">			            

                 </div>
            </div>
            <a  href="<c:url value="/reportItem/edit?id=${reportItem.id}"/>" class="btn btn-sm btn-outline-primary mt-4">Edit</a>
            <a  href="<c:url value="/reportItem/delete?id=${reportItem.id}"/>" class="btn btn-sm btn-outline-danger mt-4">Delete</a>
         </div>
    </div>
</body>
</html>