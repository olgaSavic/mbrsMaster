<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of doctors</title>
    </head>
    <body>
        <%@ include file="navigation.jsp"%>
        <div class="container">
            <br/>
            <h3 class="text-center">List of doctors</h3>
            <div>
                 <a class="btn btn-outline-primary btn-sm float-right mb-3" href="<c:url value="/doctor/new"/>">Add new doctor</a>
            </div>
            <div>
                 <table id="table_id" class="table table-sm table-hover table-bordered text-center mt-3">
                    <thead>
                    	<tr>
                        	<th>Id</th>
                        	<th>Surname</th>
                        	<th>Jmbg</th>
                        	<th>PhoneNumber</th>
                        	<th>Name</th>
                        	<th>Specialty</th>
                        	<th>Action</th>
                    	</tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${doctors}" var="doctor">
                    	<tr>
                            <td> ${doctor.id}</td>
                            <td> ${doctor.surname}</td>
                            <td> ${doctor.jmbg}</td>
                            <td> ${doctor.phoneNumber}</td>
                            <td> ${doctor.name}</td>
                            <td> ${doctor.specialty}</td>
                        	<td>
                                <a class="btn btn-sm btn-success" href="<c:url value="/doctor/${doctor.id}"/>">Detail</a>
                                <a class="btn btn-sm btn-warning" href="<c:url value="/doctor/edit?id=${doctor.id}"/>">Edit</a>
                                <a class="btn btn-sm btn-danger" href="<c:url value="/doctor/delete?id=${doctor.id}"/>">Delete</a>
                        	</td>
                    	</tr>
                    	</c:forEach>
                    </tbody>
                 </table>
            </div>
         </div>
   </body>
</html>