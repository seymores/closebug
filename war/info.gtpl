<% 
    import com.ocpsoft.pretty.time.PrettyTime
    include '/WEB-INF/includes/header.gtpl' 

    def formatter = new PrettyTime()
    def bug = request.bug
%>

    <div class="clear section_header"></div>
    <div class="container_12">

        <div class="grid_9">
            <h1>${bug.title}</h1>
        </div>
        <div class="grid_3"> </div>
        <div class="grid_9">
            <table class="bug_details">
                <tr>
                    <td> Reported by ${bug?.reporter ?: "Anonymous"} </td>

                    <td> ${formatter.format bug?.createDate} </td>

                    <td class="mark_row">
                       <span class="${bug.priority?:'normal'}"> ${bug.priority? bug.priority?.capitalize() : "Normal"} </span>
                    </td>
                    
                    <td> <span class="${bug.status?:'open'}">${bug?.status?: "Open"}</span> </td>

                </tr>
            </table>
            <p  class="bug_details" style="padding-right:1.5em">
                ${bug.desc}
            </p>
        </div>
        
        <div class="grid_3">
        tags
        </div>

    </div>

<% include '/WEB-INF/includes/footer.gtpl' %>

