package filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class loggingfilter implements Filter{
	
	private static final Logger logger = LogManager.getLogger(loggingfilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// TODO Auto-generated method stub
		Logrequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		logresponse(response);
		return response;
	}
	
	public void Logrequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE_URI"+requestSpec.getBaseUri());
		logger.info("Request Header"+requestSpec.getHeaders());
		logger.info("Request Payload"+requestSpec.getBody());
	}
	
	public void logresponse (Response response) {
		logger.info("statuscode"+response.getStatusCode());
		logger.info("response Header"+response.getHeaders());
		logger.info("response Payload"+response.getBody().asPrettyString());
		
	}

}
