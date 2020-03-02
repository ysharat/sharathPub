
fetch("https://api-sit1.loblaw.ca/v1/loayalty/corsTest", {
 // credentials: "omit",
  headers: {
	  "accept": "*/*",
	   "accept-language": "en-CA",
	   'Access-Control-Allow-Origin':'*',
	   "cache-control": "no-cache",
	   "channel-type": "WEB",
	   "content-type": "application/json",
	   "expires": "Mon, 26 Jul 1997 05:00:00 GMT",
	   "pragma": "no-cache",
	   "x-devicefingerprint": "test",
	   "x-dy6zuyp5-a": "test",
	   "x-dy6zuyp5-b": "test",
	   "x-dy6zuyp5-c": "test",
	   "x-dy6zuyp5-d": "0",
	   "x-dy6zuyp5-uniquestatekey": "test",
	 },
	 
  method: "GET",
 mode: "cors"
}).then(res => res.json())