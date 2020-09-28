<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of examinations</title>
    </head>
    <body>
        <%@ include file="navigation.jsp"%>
        <div class="container">
            <br/>
            <h3 class="text-center">List of examinations</h3>
            <div>
                 <a class="btn btn-outline-primary btn-sm float-right mb-3" href="<c:url value="/examination/new"/>">Add new examination</a>
            </div>
            <div>
                 <table id="table_id" class="table table-sm table-hover table-bordered text-center mt-3">
                    <thead>
                    	<tr>
                        	<th>Id</th>
                        	<th>Date</th>
                        	<th>Action</th>
                    	</tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${examinations}" var="examination">
                    	<tr>
                            <td> ${examination.id}</td>
                            <td> ${examination.date}</td>
                        	<td>
                                <a class="btn btn-sm btn-success" href="<c:url value="/examination/${examination.id}"/>">Detail</a>
                                <a class="btn btn-sm btn-warning" href="<c:url value="/examination/edit?id=${examination.id}"/>">Edit</a>
                                <a class="btn btn-sm btn-danger" href="<c:url value="/examination/delete?id=${examination.id}"/>">Delete</a>
                        	</td>
                    	</tr>
                    	</c:forEach>
                    </tbody>
                 </table>
            </div>
         </div>
   </body>
</html>