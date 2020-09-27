<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of pacients</title>
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
            <h5 class="text-center">List of pacients</h5>
            <div>
                 <a class="btn btn-outline-primary btn-sm float-right mb-3" href="<c:url value="/pacient/new"/>">Add new pacient</a>
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
                    	<c:forEach items="${pacients}" var="pacient">
                    	<tr>
                            <td> ${pacient.id}</td>
                            <td> ${pacient.name}</td>
                            <td> ${pacient.surname}</td>
                            <td> ${pacient.jmbg}</td>
                            <td> ${pacient.address}</td>
                            <td> ${pacient.phoneNumber}</td>
                        	<td>
                            	<a class="btn btn-sm btn-info" href="<c:url value="/pacient/${pacient.id}"/>">Detail</a>
                            	<a class="btn btn-sm btn-primary" href="<c:url value="/pacient/edit?id=${pacient.id}"/>">Edit</a>
                            	<a class="btn btn-sm btn-danger" href="<c:url value="/pacient/delete?id=${pacient.id}"/>">Delete</a>
                        	</td>
                    	</tr>
                    	</c:forEach>
                    </tbody>
                 </table>
            </div>
         </div>
   </body>
</html>