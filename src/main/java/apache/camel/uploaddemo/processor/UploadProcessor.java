package apache.camel.uploaddemo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import apache.camel.uploaddemo.bean.ResponseStatus;
import apache.camel.uploaddemo.bean.ResponseBean;



public class UploadProcessor implements Processor {

    private static final Logger uploadProcessorLogger = LoggerFactory.getLogger(UploadProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
    	uploadProcessorLogger.info("UploadProcessor|process|body {}",exchange.getIn().getBody());
        exchange.getIn().setBody(new ResponseBean(ResponseStatus.Success,exchange.getIn().getBody()));
    }
   }
