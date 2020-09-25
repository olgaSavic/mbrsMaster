<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of therapys</title>
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
            <h5 class="text-center">List of therapys</h5>
            <div>
                 <a class="btn btn-outline-primary btn-sm float-right mb-3" href="<c:url value="/therapy/new"/>">Add new therapy</a>
            </div>
            <div>
                 <table id="table_id" class="table table-sm table-hover table-bordered text-center mt-3">
                    <thead>
                    	<tr>
                        	<th>Id</th>
                        	<th>Description</th>
                        	<th>Action</th>
                    	</tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${therapys}" var="therapy">
                    	<tr>
                            <td> ${therapy.id}</td>
                            <td> ${therapy.description}</td>
                        	<td>
                            	<a class="btn btn-sm btn-info" href="<c:url value="/therapy/${therapy.id}"/>">Detail</a>
                            	<a class="btn btn-sm btn-primary" href="<c:url value="/therapy/edit?id=${therapy.id}"/>">Edit</a>
                            	<a class="btn btn-sm btn-danger" href="<c:url value="/therapy/delete?id=${therapy.id}"/>">Delete</a>
                        	</td>
                    	</tr>
                    	</c:forEach>
                    </tbody>
                 </table>
            </div>
         </div>
   </body>
</html>