import com.google.appengine.api.datastore.Entity

//System.out.println params

def bug = new Entity("bug")
bug.title = params.title
bug.desc = params.desc
bug.priority = params.priority
bug.createDate = new Date()
bug.lastUpdated = new Date()
bug.status = "open" //open,accepted,close,invalid
bug.save()

memcache.delete('firstpage')

redirect "/list"
