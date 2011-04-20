import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

System.out.println params

if (!params.id) {
    //TODO: 404
    response.status = 404
    println "No bug found with the given ID or missing ID"
}

if ("favicon.ico" == params.id) return

def key = KeyFactory.createKey("bug", params.id as Long)
assert key, "Key must not be null"


def bug = datastore.get(key)

if (bug.resolution) {
    def rKey = KeyFactory.createKey("resolution", bug.resolution )
    def resolution = rKey? datastore.get( rKey ) : null
    request.resolution = resolution
}

def comments = []
bug.comments.each { cid ->
    def comment = datastore.get( cid )
    comments << comment
}

request.bug = bug
request.comments = comments

//System.out.println bugs
forward "/info.gtpl"

