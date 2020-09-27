<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of patients</title>
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
            <h5 class="text-center">List of patients</h5>
            <div>
                 <a class="btn btn-outline-primary btn-sm float-right mb-3" href="<c:url value="/patient/new"/>">Add new patient</a>
            </div>
            <div>
                 <table id="table_id" class="table table-sm table-hover table-bordered text-center mt-3">
                    <thead>
                    	<tr>
                        	<th>Id</th>
                        	<th>Name</th>
                        	<th>Surname</th>
                        	<th>Jmbg</th>
                        	<th>Address</th>
                        	<th>PhoneNumber</th>
                        	<th>Action</th>
                    	</tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${patients}" var="patient">
                    	<tr>
                            <td> ${patient.id}</td>
                            <td> ${patient.name}</td>
                            <td> ${patient.surname}</td>
                            <td> ${patient.jmbg}</td>
                            <td> ${patient.address}</td>
                            <td> ${patient.phoneNumber}</td>
                        	<td>
                            	<a class="btn btn-sm btn-info" href="<c:url value="/patient/${patient.id}"/>">Detail</a>
                            	<a class="btn btn-sm btn-primary" href="<c:url value="/patient/edit?id=${patient.id}"/>">Edit</a>
                            	<a class="btn btn-sm btn-danger" href="<c:url value="/patient/delete?id=${patient.id}"/>">Delete</a>
                        	</td>
                    	</tr>
                    	</c:forEach>
                    </tbody>
                 </table>
            </div>
         </div>
   </body>
</html>