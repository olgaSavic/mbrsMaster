<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of reports</title>
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
            <h3 class="text-center">List of reports</h3>
            <div>
                 <a class="btn btn-outline-primary btn-sm float-right mb-3" href="<c:url value="/report/new"/>">Add new report</a>
            </div>
            <div>
                 <table id="table_id" class="table table-sm table-hover table-bordered text-center mt-3">
                    <thead>
                    	<tr>
                        	<th>Id</th>
                        	<th>Action</th>
                    	</tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${reports}" var="report">
                    	<tr>
                            <td> ${report.id}</td>
                        	<td>
                                <a class="btn btn-sm btn-success" href="<c:url value="/report/${report.id}"/>">Detail</a>
                                <a class="btn btn-sm btn-warning" href="<c:url value="/report/edit?id=${report.id}"/>">Edit</a>
                                <a class="btn btn-sm btn-danger" href="<c:url value="/report/delete?id=${report.id}"/>">Delete</a>
                        	</td>
                    	</tr>
                    	</c:forEach>
                    </tbody>
                 </table>
            </div>
         </div>
   </body>
</html>