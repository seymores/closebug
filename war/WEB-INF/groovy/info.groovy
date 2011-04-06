import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*


if (!params.id) {
    //TODO: 404
    response.status = 404
    println "No bug found with the given ID or missing ID"
}

def key = KeyFactory.createKey("bug", params.id as Long)
assert key, "Key must not be null"

System.out.println params

def bug = datastore.get(key)

request.bug = bug

//System.out.println bugs
forward "/info.gtpl"
