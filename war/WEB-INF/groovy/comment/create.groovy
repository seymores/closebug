import com.google.appengine.api.datastore.*


if (!params.bug) {
    //TODO: 404
    response.status = 404
    println "No bug found with the given ID or missing ID"
}

def key = KeyFactory.createKey("bug", params.bug as Long)
def bug = datastore.get(key) //TODO: Should query from memcache

def comment = new Entity("comment")
comment.body = params.comment
comment.author = params.author
comment.authorId = null
comment.createDate = new Date()
comment.bug = key.id

def k = comment.save()

if (bug.comments) {
    bug.comments << comment.key
} else {
    bug.comments = [comment.key]
}
bug.save()

request.bug = bug

redirect "/info/${bug.key.id}"

