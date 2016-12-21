variable "account_id" {default = ""}
variable "access_key" {default = ""}
variable "secret_key" {default = ""}
variable "region" {default = "us-east-1"}

provider "aws" {
  access_key = "${var.access_key}"
  secret_key = "${var.secret_key}"
  region = "${var.region}"
}

### api gateway

resource "aws_api_gateway_rest_api" "hipchat_message_parser_api" {
  name = "HipChat Message Parser API"
  description = "Parses special features from HipChat messages"
}

resource "aws_api_gateway_resource" "message" {
  rest_api_id = "${aws_api_gateway_rest_api.hipchat_message_parser_api.id}"
  parent_id = "${aws_api_gateway_rest_api.hipchat_message_parser_api.root_resource_id}"
  path_part = "message"
}

resource "aws_api_gateway_resource" "message_parse" {
  rest_api_id = "${aws_api_gateway_rest_api.hipchat_message_parser_api.id}"
  parent_id = "${aws_api_gateway_resource.message.id}"
  path_part = "parse"
}

resource "aws_api_gateway_method" "message_parse-post" {
  authorization = "NONE"
  http_method = "POST"
  resource_id = "${aws_api_gateway_resource.message_parse.id}"
  rest_api_id = "${aws_api_gateway_rest_api.hipchat_message_parser_api.id}"
}

resource "aws_api_gateway_integration" "message_parse-post-integration" {
  http_method = "${aws_api_gateway_method.message_parse-post.http_method}"
  resource_id = "${aws_api_gateway_resource.message_parse.id}"
  rest_api_id = "${aws_api_gateway_rest_api.hipchat_message_parser_api.id}"
  type = "AWS_PROXY"
  integration_http_method = "POST"
  uri = "arn:aws:apigateway:${var.region}:lambda:path/2015-03-31/functions/arn:aws:lambda:${var.region}:${var.account_id}:function:${aws_lambda_function.hipchat_message_parser.function_name}/invocations"
}

### lambda
resource "aws_iam_role" "hipchat_message_parser_role" {
  name = "hipchat_message_parser_role"
  assume_role_policy = <<POLICY
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "",
      "Effect": "Allow",
      "Principal": {
        "Service": "lambda.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
POLICY
}

resource "aws_iam_role_policy" "hipchat_message_parser_role_policy" {
  name = "hipchat_message_parser_role_policy"
  role = "${aws_iam_role.hipchat_message_parser_role.id}"
  policy = <<POLICY
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "dynamodb:*",
      "Effect": "Allow",
      "Resource": "*"
    },
    {
      "Action": "cloudwatch:PutMetricData",
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
POLICY
}

resource "aws_lambda_permission" "allow_api_gateway" {
  function_name = "${aws_lambda_function.hipchat_message_parser.function_name}"
  statement_id = "AllowExecutionFromApiGateway"
  action = "lambda:InvokeFunction"
  principal = "apigateway.amazonaws.com"
  source_arn = "arn:aws:execute-api:${var.region}:${var.account_id}:${aws_api_gateway_rest_api.hipchat_message_parser_api.id}/*/${aws_api_gateway_integration.message_parse-post-integration.integration_http_method}${aws_api_gateway_resource.message_parse.path}"
}

resource "aws_lambda_function" "hipchat_message_parser" {
  function_name = "hipchat_message_parser"
  runtime = "java8"
  memory_size = "512"
  timeout = "20"
  filename = "hipchat-message-parser-lambda.zip"
  handler = "lambda.HipChatMessageHandler::handleRequest"
  role = "${aws_iam_role.hipchat_message_parser_role.arn}"
}

### dynamoDB
resource "aws_dynamodb_table" "production_link_cache" {
  "attribute" {
    name = "url"
    type = "S"
  }
  hash_key = "url"
  name = "linkCache"
  read_capacity = 5
  write_capacity = 5
}
