#!/usr/bin/env bash

(cd .. && exec apex build hipchat-message-parser-lambda > deploy/hipchat-message-parser-lambda.zip)
terraform apply