

## General info
This project is simple demo for an rest api built on spring boot
	
## Technologies
Project is created with:
* Spring boot
* Mybatis
* Jersey
	
## Setup
To run this project, load the project in IDE and run the DemoApplication
http://localhost:8086/checkout
with header: Content-Type:Application/json
payload:
["001","001","001","003"]

You will get;
{
    "price": "250"
}


## Further enhancement need to be done
* Separate the discount info to another table, if we have multiple rules for the same watch
* Use lombok utility
* Need to use Money object
* Exception structure
* Error handling
* Log 
* Refactoring for the core logic 
