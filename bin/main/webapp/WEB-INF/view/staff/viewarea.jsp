<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="description" content="Seipkon is a Premium Quality Admin Site Responsive Template" />
      <meta name="keywords" content="admin template, admin, admin dashboard, cms, Seipkon Admin, premium admin templates, responsive admin, panel, software, ui, web app, application" />
      <meta name="author" content="Themescare">
      <!-- Title -->
      <title>Booth Surveillance System</title>
      <!-- Favicon -->
      <link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath()%>/adminResources/image/favicon-32x32.png">
      <!-- Animate CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/animate.min.css">
      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css">
      <!-- Font awesome CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/font-awesome.min.css">
      <!-- Themify Icon CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/themify-icons.css">
      <!-- Perfect Scrollbar CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/perfect-scrollbar.min.css">
      <!-- DataTables CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap.min.css" >
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/buttons.bootstrap.min.css" >
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/responsive.bootstrap.min.css" >
      <!-- Main CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/seipkon.css">
      <!-- Responsive CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/responsive.css">
   </head>
   <body>
       
      <!-- Start Page Loading -->
      <div id="loader-wrapper">
         <div id="loader"></div>
         <div class="loader-section section-left"></div>
         <div class="loader-section section-right"></div>
      </div>
      <!-- End Page Loading -->
       
      <!-- Wrapper Start -->
      <div class="wrapper">
         <!-- Main Header Start -->
         <header class="main-header">
             
            <!-- Logo Start -->
            <div class="seipkon-logo">
               <a href="index">
               <img src="<%=request.getContextPath()%>/adminResources/image/download.png" style= "height:65px;width:200px" alt="logo">
               </a>
            </div>
            <!-- Logo End -->
             
            <!-- Header Top Start -->
            <jsp:include page= "header.jsp"></jsp:include>
            <!-- Header Top End -->
             
         </header>
         <!-- Main Header End -->
          
         <!-- Sidebar Start -->
         <aside class="seipkon-main-sidebar">
            <jsp:include page= "menu.jsp"></jsp:include>
         </aside>
         <!-- End Sidebar -->
          
         <!-- Right Side Content Start -->
         <section id="content" class="seipkon-content-wrapper">
            <div class="page-content">
               <div class="container-fluid">
                   
                  <!-- Breadcromb Row Start -->
                  <div class="row">
                     <div class="col-md-12">
                        <div class="breadcromb-area">
                           <div class="row">
                              <div class="col-md-6 col-sm-6">
                                 <div class="seipkon-breadcromb-left">
                                    <h3>View Area</h3>
                                 </div>
                              </div>
                              <div class="col-md-6 col-sm-6">
                                 <div class="seipkon-breadcromb-right">
                                    <ul>
                                       <li><a href="index">Home</a></li>
                                       <li>Manage Area</li>
                                       <li>View Area</li>
                                    </ul>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- End Breadcromb Row -->
                   
                  <!-- Advance Table Row Start -->
                  <div class="row">
                                       </div>
                  <!-- End Advance Table Row -->
                   
                  <!-- Advance Table Row Start -->
                  <div class="row">
                     
                     
                                       </div>
                  <!-- End Advance Table Row -->
                   
                  <!-- Advance Table Row Start -->
                  <div class="row">
                     <div class="col-md-12">
                        <div class="page-box">
                           <div class="datatables-example-heading">
                              <h3>Area Enteries</h3>
                           </div>
                           <!-- <p>Responsive is an extension for DataTables that resolves that problem by optimising the table's layout for different screen sizes through the dynamic insertion and removal of columns from the table.</p> -->
                           <div class="advance-table">
                              <table id="responsive_datatables_example" class="table display table-striped table-bordered responsive nowrap">
                                 <thead>
                                    <tr>
                                       <th>areaId</th>
                                       <th>areaName</th>
                                       <th>areaDescription</th>
                                       <th>cityName</th>
                                       
                                       
                                    </tr>
                                 </thead>
                                 
                                 
                                 <%@taglib uri= "http://java.sun.com/jstl/core_rt" prefix= "c" %>
                                 <c:forEach items= "${k}" var= "z">
                                    <tr>
                                       <td>${z.areaId}</td>
                                       <td>${z.areaName}</td>
                                       <td>${z.areaDescription}</td>
                                       
                                        <td>${z.cityVO.cityName}</td>
										
                                        
                                     </tr>
                                    </c:forEach>
                                 
                                 
                                 
                                 <!--<tbody>
                                    <tr>
                                       <td>Tiger Nixon</td>
                                       <td>System Architect</td>
                                       <td>61</td>
                                       </tr>
                                    <tr>
                                       <td>Garrett Winters</td>
                                       <td>Accountant</td>
                                       <td>63</td>
                                        </tr>
                                 </tbody>-->
                                 
                                 
                              </table>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- End Advance Table Row -->
                   
               </div>
            </div>
             
            <!-- Footer Area Start -->
            <jsp:include page= "footer.jsp"></jsp:include>
            <!-- End Footer Area -->
             
         </section>
         <!-- End Right Side Content -->
          
      </div>
      <!-- End Wrapper -->
       
       
      <!-- jQuery -->
      <script src="<%=request.getContextPath()%>/adminResources/js/jquery-3.1.0.min.js"></script>
      <!-- Bootstrap JS -->
      <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.min.js"></script>
      <!-- Datatables -->
      <script src="<%=request.getContextPath()%>/adminResources/js/jquery.dataTables.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/dataTables.bootstrap.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/dataTables.buttons.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/buttons.bootstrap.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/buttons.flash.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/buttons.jsp5.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/buttons.print.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/dataTables.responsive.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/responsive.bootstrap.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/jszip.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/pdfmake.min.js"></script>
      <script src="<%=request.getContextPath()%>/adminResources/js/vfs_fonts.js"></script>
      <!-- Perfect Scrollbar JS -->
      <script src="<%=request.getContextPath()%>/adminResources/js/jquery-perfect-scrollbar.min.js"></script>
      <!-- Form Wizard Custom JS For Only This Page -->
      <script src="<%=request.getContextPath()%>/adminResources/js/advance_table_custom.js"></script>
      <!-- Custom JS -->
      <script src="<%=request.getContextPath()%>/adminResources/js/seipkon.js"></script>
   </body>
</html>