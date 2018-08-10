				<div class="container-fluid">
					<div class="row justify-content-center">
						<div class="col-sm-10">
							<nav class="navbar navbar-light header navbar-toggleable-md">	
									<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
										<span class="navbar-toggler-icon"></span>
									</button>
									<a class="navbar-brand" href="/bookmymovie"><img src="<%=request.getContextPath()%>/resources/img/logo.png" width="270" height="30"></a>

									<div class="collapse navbar-collapse menu" id="navbarSupportedContent">		
										<ul class="navbar-nav ml-auto menu-nav">
											
											<c:set var="su" value="${su}"/>
											<c:if test="${su!=null}">
												 <%@ include file ="logged-in.jsp" %>																				
											</c:if>
											<c:if test="${su==null}">
											 <%@ include file ="logged-not.jsp" %>
											</c:if>
											
										</ul>
									</div>
							</nav>
						</div>
					</div>
				</div>