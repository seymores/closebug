<% include '/WEB-INF/includes/header.gtpl' %>

    
    <div class="container_12 body_content">

    <h1 class="page_title">New Bug - CloseBug</h1>

    <form action="post" action="">
        <ul class="form">
            <li class="form">
                <label for="title" id="title" class="form"> Title </label>
                <input class="title" name="title"></input>
            </li>
            
            <li class="form">
                <label for="desc" id="description" class="form"> 
                Describe the bug in detail </label>
                <textarea name="desc"></textarea>
            </li>
            
            <li class="form"> 
                <label for="priority" class="form">Priority</label>
                <select class="form" name="priority">
                    <option value="urgent">Urgent</option>
                    <option value="important">Important</option>
                    <option value="normal">Normal</option>
                    <option value="low">Low</option>
                </select>
            </li>
            
            <li class="form">
                <input class="form_submit" type="submit" value="Submit"></input>
            </li>


        </ul>
    </form>

    </div>

<% include '/WEB-INF/includes/footer.gtpl' %>
