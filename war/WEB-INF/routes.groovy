
// routes for the blobstore service example
get "/upload",  forward: "/upload.gtpl"
get "/success", forward: "/success.gtpl"
get "/failure", forward: "/failure.gtpl"


get "/add", forward: "/add.gtpl"
get "/list", forward: "/list.groovy"

post "/create", forward: "/create.groovy"

get "/@sheetkey/add", forward: "/add.gtpl?sheetkey=@sheetkey"

get "/favicon.ico", redirect: "/images/favicon.png"
