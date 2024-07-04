<jsp:include page="header.jsp"></jsp:include>

<div class="container">



<form action="savestudent.jsp" method="post">
<h1 class="text-center">Registration From</h1>
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Name</label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" name="name">

		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Email</label> <input
				type="email" class="form-control" id="exampleInputPassword1" name="email">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Address</label>
			<input type="text" class="form-control" id="exampleInputPassword1" name="address">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Cell
				Number</label> <input type="" text"" class="form-control"
				id="exampleInputPassword1" name="cell">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>













</div>



<jsp:include page="footer.jsp"></jsp:include>