<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Transense</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/iconfonts/font-awesome/css/all.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/vendor.bundle.addons.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="${pageContext.request.contextPath }/adminResources/images/favicon.png" />
</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center auth">
        <div class="row w-100">
          <div class="col-lg-4 mx-auto">
            <div class="auth-form-light text-left p-5">
              <div class="brand-logo">
                <img src="${pageContext.request.contextPath }/adminResources/images/logo4.png" alt="logo">
              </div>
              <h6>STEP-2</h6>
              <!-- <h6 class="font-weight-light">Sign in to continue.</h6> -->
              <form class="pt-3"  action="step2" method="post">
                <!-- <div class="form-group">
                  <input type="email" class="form-control form-control-lg" name="username" placeholder="Username" path="username1">
                </div> -->
                 
                  <div class="form-group">
                  <input id="otp" type="text" class="form-control form-control-lg" placeholder="OTP" />
                </div>
                 																<span id="otpSpn"></span>
                 
                 <div class="form-group">
                  <input type="password" class="form-control form-control-lg" name="password" id="password"  placeholder="Password"/>
                </div>
                														<span id="pwdSpn"></span>
                
                <div class="form-group">
                  <input type="password" class="form-control form-control-lg" name="confirmpassword" id="confirmpassword" placeholder="ConfirmPassword" path="confirmpassword"/>
                </div>
                														<span id="con_pwdSpn"></span>
                
                
                <div class="mt-3">
                <input disabled="disabled" id="calculate" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" type="submit" value="SUBMIT">
                 <!--  <a class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" href="../../index.html">SIGN IN</a> -->
                </div>
                <div class="my-2 d-flex justify-content-between align-items-center">
                  <!-- <div class="form-check">
                    <label class="form-check-label text-muted">
                      <input type="checkbox" class="form-check-input">
                      Keep me signed in
                    </label>
                  </div>
                  <a href="#" class="auth-link text-black">Forgot password?</a>
                </div>
                <div class="mb-2">
                  <button type="button" class="btn btn-block btn-facebook auth-form-btn">
                    <i class="fab fa-facebook-f mr-2"></i>Connect using facebook
                  </button>
                </div> 
                <div class="text-center mt-4 font-weight-light">
                  Don't have an account? <a href="Loadregister" class="text-primary">Create</a>
                </div>
                 
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                -->
              </div></form>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
  <script src="${pageContext.request.contextPath }/adminResources/js/vendor.bundle.base.js"></script>
  <script src="${pageContext.request.contextPath }/adminResources/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="${pageContext.request.contextPath }/adminResources/js/off-canvas.js"></script>
  <script src="${pageContext.request.contextPath }/adminResources/js/hoverable-collapse.js"></script>
  <script src="${pageContext.request.contextPath }/adminResources/js/misc.js"></script>
  <script src="${pageContext.request.contextPath }/adminResources/js/settings.js"></script>
  <script src="${pageContext.request.contextPath }/adminResources/js/todolist.js"></script>
  
  		<script type="text/javascript">
		
		var generatedOTP = <%=session.getAttribute("generatedOTP")%>;
		
		$("#otp").keyup(function(){
			
			
			
			if(generatedOTP == $("#otp").val()){
				$("#otpSpn").html("OTP Matched.");
				$("#otpSpn").css("color" , "green");
				$("#otpSpn").css("font-weight" , "bold");
				$("#calculate").attr("disabled" , false);
			}
			else{
				$("#otpSpn").html("Wrong OTP.");
				$("#otpSpn").css("color" , "red");
				$("#otpSpn").css("font-weight" , "bold");
				$("#calculate").attr("disabled" , true);
			}
			
		});
		
		
		$("#confirmpassword").keyup(function()
				{
					if($("#password").val() == $("#confirmpassword").val()){
						$("#con_pwdSpn").html("Password Matched.");
						$("#con_pwdSpn").css("color" , "green");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , false);
					}
					else{
						$("#con_pwdSpn").html("Wrong Password.");
						$("#con_pwdSpn").css("color" , "red");
						$("#con_pwdSpn").css("color" , "red");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , true);
						}
				});
		  

	/* 	 $("#input").keyup(function(){
			  $('#result').val(md5(input.value));
		  });
		  
		  $("#reinput").keyup(function(){
			 
			  if(($("#input").val() == $("#reinput").val()) && (generatedOTP == $("#otp").val())){
				 $("#calculate").attr("disabled" , false);
				 console.log("pwd matched");
			 } 
			 else{
				 $("#calculate").attr("disabled" , true);
				 console.log("pwd not matched");
			 }
		  }); */
		  
		
		</script>
  
  <!-- endinject -->
</body>

</html>
