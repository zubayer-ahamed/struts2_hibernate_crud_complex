<%-- 
    Document   : index
    Created on : Sep 17, 2017, 10:25:05 AM
    Author     : cyclingbd007
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Struts 2 Hibernate CRUD Complex</h1>

        <div class="form_section" style="margin-bottom: 60px;">
            <s:form action="saveOrUpdate" method="post">
                
                <s:hidden name="users.id"/>
                <s:textfield name="users.name" label="User Name"/>
                <s:radio name="users.gender" label="Gender" list="{'Male','Female'}"/>
                <s:select name="users.country" label="Country" list="{'Bangladesh','India','Pakistan'}"/>
                <s:textarea name="users.aboutYou" label="About You"/>
                <s:checkbox name="users.mailingList" label="Would you like to join our mailing List"/>
                <s:submit value="Save"/>
                
            </s:form>
        </div>

        <table border="1">
            <thead>
                <tr>
                    <th colspan="8">Users Information List</th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Country</th>
                    <th>Avout You</th>
                    <th>Mailing List?</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="listUsers" var="row">
                    <tr>
                        <td>${row.id}</td>
                        <td>${row.name}</td>
                        <td>${row.gender}</td>
                        <td>${row.country}</td>
                        <td>${row.aboutYou}</td>
                        <td>${row.mailingList}</td>
                        <td><a href="editUser?id=${row.id}">Edit</a></td>
                        <td><a href="deleteUser?id=${row.id}">Delete</a></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>
