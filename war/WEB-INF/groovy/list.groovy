import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*


//System.out.println params

def query = new Query("bug")
query.addSort("createDate", Query.SortDirection.DESCENDING)
//query.addSort("status", Query.SortDirection.DESCENDING)
def preparedQuery = datastore.prepare(query)

def bugs = preparedQuery.asList(withDefaults())
request.bugs = bugs

//System.out.println bugs
forward "/list.gtpl"
