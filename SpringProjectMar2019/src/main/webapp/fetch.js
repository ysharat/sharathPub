fetch("https://api-sit1.loblaw.ca/auth/oauth/v2/token", {
 credentials: "omit",
 headers: {
      
   "accept-language": "en-CA",
   "cache-control": "no-cache",
   "channel-type": "WEB",
   "content-type": "application/x-www-form-urlencoded",
   expires: "Mon, 26 Jul 1997 05:00:00 GMT",
   pragma: "no-cache",
   "x-devicefingerprint": "test",
   "x-dy6zuyp5-a":
     "test",
   "x-dy6zuyp5-b": "test",
   "x-dy6zuyp5-c":
     "test",
   "x-dy6zuyp5-d": "0",
   "x-dy6zuyp5-uniquestatekey":
     "test"
 },
 referrer: "https://www.pcoptimum.ca/login",
 referrerPolicy: "no-referrer-when-downgrade",
 body:
   "username=sharath.yeramalla%40loblaw.ca&password=Welcome%40123&grant_type=password&client_id=3d499ca2-90ca-4680-adc7-3ce32b41f320&client_secret=7b50f0f7-fe22-4e24-a0d8-ff3a9498a0ca&scope=authorized%20recognized",
 method: "POST",
 mode: "cors"
}).then(res => res.json())