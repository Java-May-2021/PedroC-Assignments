<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey</title>
	<link rel="stylesheet" href="/css/styles.css" />
</head>
<body>
	<form method="POST" action="/result">
		<div class="row">
			<div class="col-left">
				Your Name:
			</div>
			<div class="col-right">
				<input type="text" name="name" />
			</div>
		</div>
		<div class="row">
			<div class="col-left">
				Dojo Location:
			</div>
			<div class="col-right">
				<select name="location">
					<option value="Online">Online</option>
					<option value="San Jose">San Jose</option>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-left">
				Favorite Language:
			</div>
			<div class="col-right">
				<select name="favlanguage">
					<option value="Java">Java</option>
					<option value="Python">Python</option>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-wide">
				Comment (optional):
			</div>
		</div>
		<div class="row">
			<div class="col-wide">
				<textarea name="comment"></textarea>
			</div>
		</div>
		<div class="row">
			<div class="col-wide">
				<button>Submit</button>
			</div>
		</div>
	</form>
</body>
</html>