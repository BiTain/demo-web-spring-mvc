<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/admin/new/list"/>
<c:url var="editNewURL" value="/admin/new/edit"/>
<c:url var="newAPI" value="/api/new"/>
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>

					<li><a href="#">Forms</a></li>
					<li class="active">Form Elements</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">
	  							${message}
							</div>
						</c:if>
						<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
							<div class="form-group">
								<label for="categoryCode">thể loại</label>
								<form:select path="categoryCode" id="categoryCode">
									<form:option value="" label="chọn thể loại"/>
									<form:options items="${categories}"/>
								</form:select>
							</div>
							<div class="form-group">
								<label for="name"
									class="col-sm-3 control-label no-padding-right">tên bài viết</label>
								<div class="col-sm-9">
									<form:input cssClass="col-xs-10 col-sm-5" path="title" id="title"/>
								</div>
							</div>
							<div class="form-group">
								<label for="thumbnail"
									class="col-sm-3 control-label no-padding-right">ảnh đại diện</label>
								<div class="col-sm-9">
									<input type="file" id="thumbnail" name="thumbnail" class="col-xs-10 col-sm-5"/>
								</div>
							</div>
							<div class="form-group">
								<label for="shortDescription">mô tả ngắn</label>
								<form:textarea cssClass="form-control" path="shortDescription" id="shortDescription" rows="" cols=""/>
							</div>
							<div class="form-group">
								<label for="content">nội dung</label>
								<form:textarea cssClass="form-control" path="content" id="content" rows="" cols=""/>
							</div>
							<form:hidden path="id" id="id"/>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${not empty model.id }">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i>
											Cập nhật bài viết
										</button>
									</c:if>
									<c:if test="${empty model.id }">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i>
											Thêm bài viết
										</button>
									</c:if>
											&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										Hủy
									</button>
								</div>		
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#btnAddOrUpdateNew').click(function(e){
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData,function(i,v){
				data[""+v.name+""] = v.value;
			});
			var id = $('#id').val();
			if(id==""){
				addNew(data);
			}else{
				updateNew(data);
			}
		});
		function addNew(data){
			$.ajax({
				url: '${newAPI}',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(result){
					window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
				},
				error: function(error){
					window.location.href = "${newURL}?page=1&limit=2&message=error_system";
				}
			});
		}
		function updateNew(data){
			$.ajax({
				url: '${newAPI}',
				type: 'PUT',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(result){
					window.location.href = "${editNewURL}?id="+result.id+"&message=update_success";
				},
				error: function(error){
					window.location.href = "${editNewURL}?id="+result.id+"&message=error_system";
				}
			});
		}
	</script>
</body>
</html>