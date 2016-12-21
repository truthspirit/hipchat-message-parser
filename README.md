# hipchat-message-parser
A microservice for parsing special features out of hipchat messages.

# Design Decision Log
1 - 2016.12.20 - Picked an AWS cloud implementation using API Gateway and Lambda, the other contender was Dropwizard deployed on AWS EC2 instances. This service seems better suited as a microservice, so Lambda won.

2 - 2016.12.20 - Determined that caching/throttling calls to external web pages to scrape the title was necessary for security. Without caching or throttling of some sort, this service could be used as part of denial of service attacks against arbitrary websites. Using a malformed URL would effectively target our ISP's DNS server.

3 - 2016.12.20 - Determined that AWS DynamodDB would be a good cache datastore for the lambda based microservice. Although elasticache memcached provided much better performance, it is visible to the public internet making it not an ideal place to store internal service state. Amazon RDS was another, slightly faster option, but it requires more maintenance and monitoring for not much performance difference. In the end Dynamo was sufficiently fast and extremely easy to deploy and maintain.

4 - 2016.12.20 - Chose maven, apex and terraform as build/deploy tools. The tool chain isn't perfectly aligned, but all three tools work together without interference. Maven is a solid industry standard build dependency management tool. Terraform is a go-based cloudformation replacement, it allows for much simpler configuration of orchestrated cloud services. Apex sits on top of maven and can be used to quickly deploy a lambda function for development. It can build lambda java artifacts used by terraform. Apex is also capable of producing golang artifacts for lambda using a js or python shim, making it useful for future golang development.


# Future improvements
1 - Put an elasticache in front of the apigateway for performance.
2 - Lambda-based integration testing. There are test harness and https invoker blueprints in AWS lambda that makes this easy.
3 - Rewrite in golang.