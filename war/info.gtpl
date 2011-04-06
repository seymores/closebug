<% 
    import com.ocpsoft.pretty.time.PrettyTime
    include '/WEB-INF/includes/header.gtpl' 

    def formatter = new PrettyTime()
    def bug = request.bug
%>

    <div class="containter_12">

        <div class="grid_12">
            <h1>${bug.title}</h1>
            <table>
                <tr>
                    <td> ${bug?.reporter ?: "Anonymous"} </td>

                    <td> ${bug.createDate} </td>

                    <td> ${bug?.priority ?: "Normal"} </td>
                    
                    <td> ${bug?.status?: "Open"} </td>

                </tr>
            </table>
            <p>
                ${bug.desc}
            </p>
        </div>
        

    </div>

<% include '/WEB-INF/includes/footer.gtpl' %>

