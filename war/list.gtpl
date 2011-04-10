<% 
    import com.ocpsoft.pretty.time.PrettyTime
    include '/WEB-INF/includes/header.gtpl' 

    def formatter = new PrettyTime()
%>

    <div class="clear section_header"></div>
    <div class="container_12">

        <div class="grid_9"><h1>Open Bugs - ${request.bugsheet?.title ?: "CloseBug Dev Project"}</h1></div>
        <div class="grid_3">
        </div>

        <div class="grid_9">
            
            <table class="listing">
                <thead style="display:none"> <!-- {{{ -->
                    <tr>
                      <th>#</th>
                      <th>Title</th>
                      <th>By</th>
                      <th>Status</th>
                      <th>Date</th>
                    </tr><!-- }}} -->
                </thead>

                <tbody>

                    <%
                        request?.bugs?.each { bug ->
                    %>
                    <tr>
                        <td class>
                            <span class="bug_title"><a href="/info/${bug.key.id}">#${bug?.key.id}</a></span>
                        </td>
                        <td>
                            <span class="bug_title"> <a href="/${bug.key.id}">${bug?.title}</a> </span>
                            <span class="bug_small_details"><a href="#">${bug.reporter?: "Anonymous"}</a>
                             - ${ formatter.format bug?.createDate }, 0 comments </span>
                        </td>

                        <td class="mark_row">
                           <span class="${bug.priority?:'normal'}"> ${bug.priority? bug.priority?.capitalize() : "Normal"} </span>
                        </td>
                        
                        <td class="mark_row" style="display:none">
                            <span class="${bug.status?:'open'}">${bug.status ? bug.status?.capitalize() : "Open"}</span>
                        </td>
                    </tr>
                    <%
                        }
                    %>

                </tbody>
    
            </table>

        </div>

        <div class="grid_3"> 
            <div class="button"><a href="/add" class="button"><span class="add">New Bug</span></a></div>
        </div>

    </div>




<% include '/WEB-INF/includes/footer.gtpl' %>

