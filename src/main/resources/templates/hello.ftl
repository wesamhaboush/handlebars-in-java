<script id="some-id" type="text/x-handlebars-template">
    <table>
        <thead>
        <th>Username</th>
        <th>Real Name</th>
        <th>Email</th>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.email}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</script>
