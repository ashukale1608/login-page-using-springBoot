<%@ page language="java" contentType="text/html ; charset=UTF-8"
  pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html ; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <style>
        input{
            border-radius: 5px;
            border: 1px solid gray;
            box-shadow: 0px 2px 7px 1px gray;
        }
    </style>
</head>
<body>
   <form action="addDataByWeb" class="text-center">
    <br>
    <h3 class="text-info" class="mt-3">Log In</h3>
    <br>
    <b><label for="" class="mr-3">Name : </label></b>
    <input type="text" name="name" class="ml-2">
    <br>
    <br>
    <b><label for="" class="mr-4">Email : </label></b>
    <input type="email" name="email" class="ml-1">
    <br>
    <br>
    <b><label for="" class="mr-1">Password : </label></b>
    <input type="password" name="password">
    <br>
    <br>
    <button class="btn btn-info">Log In</button>
  </form> 
</body>
</html>