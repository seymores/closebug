<% 
    import com.ocpsoft.pretty.time.PrettyTime
    include '/WEB-INF/includes/header.gtpl' 

    def formatter = new PrettyTime()
    def bug = request.bug
    def resolution = request.resolution
%>

    <div class="clear section_header"></div>
    <div class="container_12">

        <div class="grid_9">
            <h1>${bug.title}</h1>
        </div>
        <div class="grid_3"> </div>
        

        <div class="grid_9">

            <div style="margin-bottom:10px">
                Reported by ${bug?.reporter ?: "Anonymous"}, 
                ${formatter.format bug?.createDate} 
               <span class="${bug.priority?:'normal'}"> ${bug.priority? bug.priority?.capitalize() : "Normal"} </span>
                <span class="${bug.status?:'open'}"> ${bug?.status?: "Open"} </span> 
            </div>

            <p  class="bug_details" style="padding-right:1.5em">
                ${bug.desc}
            </p>

            <div class="grid_9">

                <% if (resolution) { %>
                <div class="solution_details">
                    <h6>Fix</h6>
                    <p>${resolution.fixDescription}</p>
                    
                    <h6>Prevention fix</h6>
                    <p>${resolution.preventionDescription}</p>
                </div>
                <% } else { %>

                <form action="/resolve" method="post" style="display:${resolution?'none':''}">
                        <input type="hidden" name="id" value="${bug.key.id}" />
                        <ul class="form">
                            
                            <li class="form">
                                <label class="form" id="description" for="fix"> 
                                What is the immediate fix? </label>
                                <textarea name="fix"></textarea>
                            </li>
                            
                            <li class="form"> 
                                <label class="form" for="priority">How to prevent this bug from happening again?</label>
                                <textarea name="prevention"></textarea>
                            </li>
                            
                            <li class="form">
                                <input type="submit" value="Submit" class="form_submit">
                                or 
                                <a href="/list">Cancel</a>
                            </li>

                    </ul>
                </form>

                <% } %>
                
            </div>
        </div>
        
        <div class="grid_3">
        tags
        </div>

    </div>

<% include '/WEB-INF/includes/footer.gtpl' %>

