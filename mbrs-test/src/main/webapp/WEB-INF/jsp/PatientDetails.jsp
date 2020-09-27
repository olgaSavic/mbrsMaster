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
            <h5>Patient details</h5>
            <div>
                 <div>
                        <div class="m-2">
                            <span>Id: <span class="font-weight-bold">${patient.id}</span></span>
                        </div>
                        <hr class="my-2">			            
                        <div class="m-2">
                            <span>Name: <span class="font-weight-bold">${patient.name}</span></span>
                        </div>
                        <hr class="my-2">			            
                        <div class="m-2">
                            <span>Surname: <span class="font-weight-bold">${patient.surname}</span></span>
                        </div>
                        <hr class="my-2">			            
                        <div class="m-2">
                            <span>Jmbg: <span class="font-weight-bold">${patient.jmbg}</span></span>
                        </div>
                        <hr class="my-2">			            
                        <div class="m-2">
                            <span>Address: <span class="font-weight-bold">${patient.address}</span></span>
                        </div>
                        <hr class="my-2">			            
                        <div class="m-2">
                            <span>PhoneNumber: <span class="font-weight-bold">${patient.phoneNumber}</span></span>
                        </div>
                        <hr class="my-2">			            

                             <div class="m-2">
                                 <span>Doctor: <span class="font-weight-bold">${patient.doctor.id}</span></span>
                             </div>
                             <hr class="my-2">





                 </div>
            </div>
            <a  href="<c:url value="/patient/edit?id=${patient.id}"/>" class="btn btn-sm btn-outline-primary mt-4">Edit</a>
            <a  href="<c:url value="/patient/delete?id=${patient.id}"/>" class="btn btn-sm btn-outline-danger mt-4">Delete</a>
         </div>
    </div>
</body>
</html>