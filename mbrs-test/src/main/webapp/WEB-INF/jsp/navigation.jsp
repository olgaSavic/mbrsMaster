<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link type="text/css" rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>       
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
           <a class="navbar-brand font-weight-bold" href="/">MBRSApp</a>
           <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
	            aria-controls="navbarNav" aria-expanded="true" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
           </button>
           <div class="collapse navbar-collapse" id="navbarNav">
               <ul class="nav navbar-nav">
                  <li class="nav-item">
                  	 <c:url var="diagnosis_all" value="/allDiagnosiss" />
                     <a class="nav-link" href="${diagnosis_all}">Diagnosis</a>
                  </li>
                  <li class="nav-item">
                  	 <c:url var="doctor_all" value="/allDoctors" />
                     <a class="nav-link" href="${doctor_all}">Doctor</a>
                  </li>
                  <li class="nav-item">
                  	 <c:url var="examination_all" value="/allExaminations" />
                     <a class="nav-link" href="${examination_all}">Examination</a>
                  </li>
                  <li class="nav-item">
                  	 <c:url var="patient_all" value="/allPatients" />
                     <a class="nav-link" href="${patient_all}">Patient</a>
                  </li>
                  <li class="nav-item">
                  	 <c:url var="report_all" value="/allReports" />
                     <a class="nav-link" href="${report_all}">Report</a>
                  </li>
                  <li class="nav-item">
                  	 <c:url var="reportItem_all" value="/allReportItems" />
                     <a class="nav-link" href="${reportItem_all}">ReportItem</a>
                  </li>
                  <li class="nav-item">
                  	 <c:url var="symptom_all" value="/allSymptoms" />
                     <a class="nav-link" href="${symptom_all}">Symptom</a>
                  </li>
                  <li class="nav-item">
                  	 <c:url var="therapy_all" value="/allTherapys" />
                     <a class="nav-link" href="${therapy_all}">Therapy</a>
                  </li>
               </ul>
               <ul class="nav navbar-nav ml-auto">
                   <li class="nav-item">
                      <a class="nav-link" href="/register"> Register </a>
                   </li>
                   <li class="nav-item">
                      <a class="nav-link" href="/login"> Login </a>
                   </li>
               </ul>
           </div>
        </nav>
    </body>
</html>