package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaProxyRequestHandler implements RequestHandler<LambdaProxyRequest, LambdaProxyResponse> {
    public LambdaProxyResponse handleRequest(LambdaProxyRequest lambdaProxyRequest, Context context) {
        return null;
    }
}
