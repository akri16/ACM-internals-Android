const fs = require("fs"); 
   
// Read .secrets.bseline file 
fs.readFile(".secrets.baseline", function(err, data) { 
      
    // Check for errors 
    if (err) throw err; 
   
    // Converting to JSON 
    const secret_baseline = JSON.parse(data); 

    //Check for existence of secrets
    if (Object.keys(secret_baseline.results).length > 0) {
        const err = "Secrets found in code..." + "\n Following secrets were found:\n" + secret_baseline.results + "\n\n Terminating Check..."
        throw new Error(err)
    }
      
    // Print success 
    console.log("Success: No secrets found in code"); 
}); 
