import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*


//System.out.println params

int PAGE_SIZE = 15

def bugs = null
def startCursor = request.cursor

if (('page'+startCursor) in memcache) {
    bugs = memcache['page'+startCursor]    
}

def fetchOptions = FetchOptions.Builder.withLimit(PAGE_SIZE);
if (startCursor) {
    fetchOptions.startCursor(Cursor.fromWebSafeString(startCursor));
}

if (!bugs) {
    def query = new Query("bug")
    query.addSort("createDate", Query.SortDirection.DESCENDING)
    query.addFilter("status", Query.FilterOperator.EQUAL, "open")
   // query.addFilter("status", Query.FilterOperator.EQUAL, "reopen")
  //  query.addFilter("status", Query.FilterOperator.IN, ["open", "reopen"])a //Not supported if using cursor
    
    def preparedQuery = datastore.prepare(query)
 //   bugs = preparedQuery.asList(withDefaults())
    bugs = preparedQuery.asQueryResultList(fetchOptions);
    startCursor = bugs.getCursor().toWebSafeString()
    String c = "page-" + startCursor.toString() 
 //   System.out.println bugs.toList()
    memcache[c] = bugs.toList()
}

request.cursor = startCursor
request.bugs = bugs

//System.out.println bugs
forward "/list.gtpl"
