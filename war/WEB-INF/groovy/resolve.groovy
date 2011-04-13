import com.google.appengine.api.datastore.*


if (!params.id) {
    //TODO: 404
    response.status = 404
    println "No bug found with the given ID or missing ID"
}

System.out.println params

def key = KeyFactory.createKey("bug", params.id as Long)
def bug = datastore.get(key)
def resolution = null

if (bug.resolution) { 
    resolution = datastore.get("resolution", bug.resolution)
    resolution.lastUpdated = new Date()
} else {
    resolution = new Entity("resolution")
    resolution.createDate = new Date()
    resolution.save()
    bug.resolution = resolution.key.id
}

resolution.fixDescription = params.fix
resolution.preventionDescription = params.prevention ?: "NA"
resolution.save()

bug.status = "resolved"
bug.save()

redirect "/${bug.key.id}"

