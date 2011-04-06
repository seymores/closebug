
// routes for the blobstore service example
get "/upload",  forward: "/upload.gtpl"
get "/success", forward: "/success.gtpl"
get "/failure", forward: "/failure.gtpl"
get "/", forward: "/list.groovy"

get "/add", forward: "/add.gtpl"
get "/list", forward: "/list.groovy"
get "/info/@id", forward: "/info.groovy?id=@id"

post "/create", forward: "/create.groovy"

get "/@sheetkey/add", forward: "/add.gtpl?sheetkey=@sheetkey"

get "/favicon.ico", redirect: "/images/favicon.png"
