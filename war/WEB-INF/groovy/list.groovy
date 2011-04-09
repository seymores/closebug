import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*


//System.out.println params

def bugs = null

if ('firstpage' in memcache) {
    bugs = memcache['firstpage']    
}

if (!bugs) {
    def query = new Query("bug")
    query.addSort("createDate", Query.SortDirection.DESCENDING)
    //query.addSort("status", Query.SortDirection.DESCENDING)
    def preparedQuery = datastore.prepare(query)

    bugs = preparedQuery.asList(withDefaults())
    memcache['firstpage'] = bugs
}

request.bugs = bugs

//System.out.println bugs
forward "/list.gtpl"
