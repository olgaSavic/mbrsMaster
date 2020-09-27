<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of symptoms</title>
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
            <br/>
            <h3 class="text-center">List of symptoms</h3>
            <div>
                 <a class="btn btn-outline-primary btn-sm float-right mb-3" href="<c:url value="/symptom/new"/>">Add new symptom</a>
            </div>
            <div>
                 <table id="table_id" class="table table-sm table-hover table-bordered text-center mt-3">
                    <thead>
                    	<tr>
                        	<th>Id</th>
                        	<th>Name</th>
                        	<th>Description</th>
                        	<th>Action</th>
                    	</tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${symptoms}" var="symptom">
                    	<tr>
                            <td> ${symptom.id}</td>
                            <td> ${symptom.name}</td>
                            <td> ${symptom.description}</td>
                        	<td>
                                <a class="btn btn-sm btn-success" href="<c:url value="/symptom/${symptom.id}"/>">Detail</a>
                                <a class="btn btn-sm btn-warning" href="<c:url value="/symptom/edit?id=${symptom.id}"/>">Edit</a>
                                <a class="btn btn-sm btn-danger" href="<c:url value="/symptom/delete?id=${symptom.id}"/>">Delete</a>
                        	</td>
                    	</tr>
                    	</c:forEach>
                    </tbody>
                 </table>
            </div>
         </div>
   </body>
</html>