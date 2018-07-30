		<%@include file="template/navbar.jsp" %>
		<form id="Log" action="perform_login" method="post">
			<div class="container">
				<div class="row" style="margin-top:100px;margin-left:100px;">
					<div class="col-sm-4 col-sm-offset-4 col-lg-4 col-lg-offset-4">
						<div class="box">
							<!-- <div class="center-block"> -->
								<h2>Login</h2>
									<div class="input-group">
								      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
								      <input id="Username" type="text" class="form-control" name="username" placeholder="Username" required/>
								    </div>
								    <br>
								    <div class="input-group">
								      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
								      <input id="Password" type="password" class="form-control" name="password" placeholder="Password" required/>
								    </div>
								    <br/>
								<button type="submit" class="btn btn-success">Submit</button>
								<br>
								<br>
								<p>Not a member? <a href="user">Sign Up</a></p>
							<a1>Forgot Password</a1>
							<!-- </div> -->
						</div>
					</div>
				</div>
			</div>
		</form>